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
import com.exam.portal.exam.portal.dto.Response_Vocabulary_EtoJ_Dto;
import com.exam.portal.exam.portal.dto.Response_Vocabulary_JtoE_Dto;
import com.exam.portal.exam.portal.entities.Lesson;
import com.exam.portal.exam.portal.entities.Video;
import com.exam.portal.exam.portal.entities.Vocabulary;
import com.exam.portal.exam.portal.entities.VocabularyEtoJ;
import com.exam.portal.exam.portal.services.Lesson_Service;
import com.exam.portal.exam.portal.services.Video_Service;
import com.exam.portal.exam.portal.services.VocabularyEtoJ_Service;
import com.exam.portal.exam.portal.services.Vocabulary_Service;

@RestController
@RequestMapping("/vocabularyEtoJ")
@CrossOrigin(origins = "http://localhost:4200")
public class VocabularyEtoJ_Controller {
	
	@Autowired
	Lesson_Service lessonService;
	
	@Autowired
	VocabularyEtoJ_Service vocabularyEtoJ_service;
	
	@GetMapping("/vocabularyEtoJ/{id}")
	public ResponseEntity<List<Response_Vocabulary_EtoJ_Dto>> showVocabsByLessonId(@RequestParam Integer id){
		
		List<Response_Vocabulary_EtoJ_Dto> response = new ArrayList<Response_Vocabulary_EtoJ_Dto>();
		List<VocabularyEtoJ> findVocabularyEtoJByLessonId = vocabularyEtoJ_service.findVocabularyEtoJByLessonId(id);
		for(VocabularyEtoJ v : findVocabularyEtoJByLessonId) {
		 
			Response_Vocabulary_EtoJ_Dto res = new Response_Vocabulary_EtoJ_Dto();
			BeanUtils.copyProperties(v, res);
			res.setLessonId(id);
			response.add(res);
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	
	@PostMapping("/vocabularyEtoJ")
	public ResponseEntity<Response_Vocabulary_EtoJ_Dto> addVocabulary(@RequestBody Add_Vocabulary_dto addvocabularydto){
		
		VocabularyEtoJ vocabs = new VocabularyEtoJ();
		Response_Vocabulary_EtoJ_Dto res_vocab_etoj = new Response_Vocabulary_EtoJ_Dto();
		Lesson findLesson = lessonService.findLesson(addvocabularydto.getLessonId());
		if(findLesson!=null) {
			vocabs.setLesson(findLesson);
			vocabs.setEnglish_character(addvocabularydto.getEnglish_character());
			vocabs.setHiragana_character(addvocabularydto.getHiragana_character());
			vocabs.setKanji_character(addvocabularydto.getKanji_character());
			vocabs.setRomaji_character(addvocabularydto.getRomaji_character());
			VocabularyEtoJ addedVocabulary = this.vocabularyEtoJ_service.addVocabulary(vocabs);
			BeanUtils.copyProperties(addedVocabulary, res_vocab_etoj);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(res_vocab_etoj);
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
		
		
	}
	
	@PatchMapping("/vocabularyEtoJ")
	public ResponseEntity<String> editVocabulary(@RequestBody Edit_Vocabulary_dto edit_Vocabulary_dto){
		
		VocabularyEtoJ vocabs = new VocabularyEtoJ();
		Lesson findLesson = lessonService.findLesson(edit_Vocabulary_dto.getLessonId());
		if(findLesson!=null) {
			vocabs.setLesson(findLesson);
			BeanUtils.copyProperties(edit_Vocabulary_dto, vocabs);
			vocabularyEtoJ_service.addVocabulary(vocabs);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("VocabularyEtoJ details updated Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Lesson Not Found");
		
		
	}
	
	@DeleteMapping("/vocabularyEtoJ/{id}")
	public ResponseEntity<String> deleteVocabulary(@PathVariable Integer id){
		
	
		VocabularyEtoJ vocabs = vocabularyEtoJ_service.findVocabulary(id);
		String deleteVocabulary = vocabularyEtoJ_service.deleteVocabularyEtoJ(vocabs);
		return ResponseEntity.status(HttpStatus.OK).body(deleteVocabulary);
		
		
	}

}
