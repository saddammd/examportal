package com.exam.portal.exam.portal.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.exam.portal.dto.Add_Video_dto;
import com.exam.portal.exam.portal.dto.Add_Vocabulary_dto;
import com.exam.portal.exam.portal.dto.Edit_Video_dto;
import com.exam.portal.exam.portal.dto.Edit_Vocabulary_dto;
import com.exam.portal.exam.portal.entities.Lesson;
import com.exam.portal.exam.portal.entities.Video;
import com.exam.portal.exam.portal.entities.Vocabulary;
import com.exam.portal.exam.portal.services.Lesson_Service;
import com.exam.portal.exam.portal.services.Video_Service;
import com.exam.portal.exam.portal.services.Vocabulary_Service;

@RestController
@RequestMapping("/vocabulary")
public class Vocabulary_Controller {
	
	@Autowired
	Lesson_Service lessonService;
	
	@Autowired
	Vocabulary_Service vocabulary_service;
	
	@PostMapping("/vocabulary")
	public ResponseEntity<String> addVocabulary(@RequestBody Add_Vocabulary_dto addvocabularydto){
		
		Vocabulary vocabs = new Vocabulary();
		Lesson findLesson = lessonService.findLesson(addvocabularydto.getLessonId());
		if(findLesson!=null) {
			vocabs.setLesson(findLesson);
			BeanUtils.copyProperties(addvocabularydto, findLesson);
			vocabulary_service.addVocabulary(vocabs);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Vocabulary Added Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Lesson Not Found");
		
		
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
