package com.exam.portal.exam.portal.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.exam.portal.dto.Add_Video_dto;
import com.exam.portal.exam.portal.dto.Add_Vocabulary_dto;
import com.exam.portal.exam.portal.dto.Edit_Video_dto;
import com.exam.portal.exam.portal.dto.Edit_Vocabulary_dto;
import com.exam.portal.exam.portal.dto.Response_Vocabulary_JtoE_Dto;
import com.exam.portal.exam.portal.entities.Lesson;
import com.exam.portal.exam.portal.entities.Video;
import com.exam.portal.exam.portal.entities.Vocabulary;
import com.exam.portal.exam.portal.services.Lesson_Service;
import com.exam.portal.exam.portal.services.Video_Service;
import com.exam.portal.exam.portal.services.Vocabulary_Service;

@RestController
@RequestMapping("/vocabulary")
@CrossOrigin(origins = "http://localhost:4200")
public class Vocabulary_Controller {
	
	@Autowired
	Lesson_Service lessonService;
	
	@Autowired
	Vocabulary_Service vocabulary_service;
	
	
	@GetMapping("/vocabulary/{id}")
	public ResponseEntity<List<Response_Vocabulary_JtoE_Dto>> showVocabsByLessonId(@RequestParam Integer id){
		
		List<Response_Vocabulary_JtoE_Dto> response = new ArrayList<Response_Vocabulary_JtoE_Dto>();
		List<Vocabulary> findVocabularyByLessonId = vocabulary_service.findVocabularyByLessonId(id);
		for(Vocabulary v : findVocabularyByLessonId) {
		 
			Response_Vocabulary_JtoE_Dto res = new Response_Vocabulary_JtoE_Dto();
			BeanUtils.copyProperties(v, res);
			res.setLessonId(id);
			response.add(res);
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}
	
	@PostMapping("/vocabulary")
	public ResponseEntity<Response_Vocabulary_JtoE_Dto> addVocabulary(@RequestBody Add_Vocabulary_dto addvocabularydto){
		
		Vocabulary vocabs = new Vocabulary();
		Response_Vocabulary_JtoE_Dto res_vocab_jtoe = new Response_Vocabulary_JtoE_Dto();
		Lesson findLesson = lessonService.findLesson(addvocabularydto.getLessonId());
		if(findLesson!=null) {
			vocabs.setLesson(findLesson);
			vocabs.setEnglish_character(addvocabularydto.getEnglish_character());
			vocabs.setHiragana_character(addvocabularydto.getHiragana_character());
			vocabs.setKanji_character(addvocabularydto.getKanji_character());
			vocabs.setRomaji_character(addvocabularydto.getRomaji_character());
			Vocabulary addedVocabulary = vocabulary_service.addVocabulary(vocabs);
			BeanUtils.copyProperties(addedVocabulary, res_vocab_jtoe);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(res_vocab_jtoe);
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
		
		
	}
	
	@PatchMapping("/vocabulary")
	public ResponseEntity<String> editVocabulary(@RequestBody Edit_Vocabulary_dto edit_Vocabulary_dto){
		
		Vocabulary vocabs = new Vocabulary();
		Lesson findLesson = lessonService.findLesson(edit_Vocabulary_dto.getLessonId());
		if(findLesson!=null) {
			vocabs.setLesson(findLesson);
			BeanUtils.copyProperties(edit_Vocabulary_dto, vocabs);
			vocabulary_service.addVocabulary(vocabs);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Vocabulary details updated Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Lesson Not Found");
		
		
	}
	
	@DeleteMapping("/vocabulary/{id}")
	public ResponseEntity<String> deleteVocabulary(@PathVariable Integer id){
		
	
		Vocabulary vocabs = vocabulary_service.findVocabulary(id);
		String deleteVocabulary = vocabulary_service.deleteVocabulary(vocabs);
		return ResponseEntity.status(HttpStatus.OK).body(deleteVocabulary);
		
		
	}

}
