package com.exam.portal.exam.portal.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.exam.portal.dto.Add_Reading_dto;
import com.exam.portal.exam.portal.dto.Add_Video_dto;
import com.exam.portal.exam.portal.dto.Edit_Reading_dto;
import com.exam.portal.exam.portal.dto.Edit_Video_dto;
import com.exam.portal.exam.portal.entities.Lesson;
import com.exam.portal.exam.portal.entities.Reading;
import com.exam.portal.exam.portal.entities.Video;
import com.exam.portal.exam.portal.services.Lesson_Service;
import com.exam.portal.exam.portal.services.Reading_Service;
import com.exam.portal.exam.portal.services.Video_Service;

@RestController
@RequestMapping("/reading")
public class Reading_Controller {
	
	@Autowired
	Lesson_Service lessonService;
	
	@Autowired
	Reading_Service reading_service;
	
	@PostMapping("/reading")
	public ResponseEntity<String> addReadingSection(@RequestBody Add_Reading_dto addreadingdto){
		
		Reading reading = new Reading();
		Lesson findLesson = lessonService.findLesson(addreadingdto.getLessonId());
		if(findLesson!=null) {
			reading.setLesson(findLesson);
			BeanUtils.copyProperties(addreadingdto, reading);
			reading_service.addReading(reading);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Reading section Added Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Lesson Not Found");
		
		
	}
	
	@PutMapping("/reading")
	public ResponseEntity<String> editReadingSection(@RequestBody Edit_Reading_dto edit_Reading_dto){
		
		Reading reading = new Reading();
		Lesson findLesson = lessonService.findLesson(edit_Reading_dto.getLessonId());
		if(findLesson!=null) {
			reading.setLesson(findLesson);
			BeanUtils.copyProperties(edit_Reading_dto, reading);
			reading_service.addReading(reading);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Reading section details updated Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Lesson Not Found");
		
		
	}
	
	@DeleteMapping("/reading/{id}")
	public ResponseEntity<String> deleteReadingSection(@PathVariable Integer id){
		
	
		Reading reading = reading_service.findReading(id);
		String deleteReading = reading_service.deleteReading(reading);
		return ResponseEntity.status(HttpStatus.OK).body(deleteReading);
		
		
	}

}
