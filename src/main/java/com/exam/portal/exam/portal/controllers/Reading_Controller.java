package com.exam.portal.exam.portal.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.exam.portal.dto.Add_Reading_dto;
import com.exam.portal.exam.portal.dto.Add_Video_dto;
import com.exam.portal.exam.portal.dto.Edit_Reading_dto;
import com.exam.portal.exam.portal.dto.Edit_Video_dto;
import com.exam.portal.exam.portal.dto.Response_Reading_dto;
import com.exam.portal.exam.portal.entities.Lesson;
import com.exam.portal.exam.portal.entities.Reading;
import com.exam.portal.exam.portal.entities.Video;
import com.exam.portal.exam.portal.services.Lesson_Service;
import com.exam.portal.exam.portal.services.Reading_Service;
import com.exam.portal.exam.portal.services.Video_Service;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reading")
public class Reading_Controller {
	
	@Autowired
	Lesson_Service lessonService;
	
	@Autowired
	Reading_Service reading_service;
	
	@GetMapping("/reading/{id}")
	public ResponseEntity<Response_Reading_dto> showReading(@RequestParam Integer id){
		
		Response_Reading_dto readingdto = new Response_Reading_dto();
		Reading ReadingByLessonId = reading_service.findReadingByLessonId(id);
		BeanUtils.copyProperties(ReadingByLessonId, readingdto);
		readingdto.setLessonId(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(readingdto);		
	}
	
	@PostMapping("/reading")
	public ResponseEntity<Response_Reading_dto> addReadingSection(@RequestBody Add_Reading_dto addreadingdto){
		
		Reading reading = new Reading();
		Response_Reading_dto res_reading_dto = new Response_Reading_dto();
		Lesson findLesson = lessonService.findLesson(addreadingdto.getLessonId());
		if(findLesson!=null) {
			reading.setLesson(findLesson);
			reading.setContent(addreadingdto.getContent());
			reading.setHeading(addreadingdto.getHeading());
			reading.setImageUrl(addreadingdto.getImageUrl());
			reading.setSubheading(addreadingdto.getSubheading());
			Reading addedReading = reading_service.addReading(reading);
			BeanUtils.copyProperties(addedReading, res_reading_dto);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(res_reading_dto);
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
		
		
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
