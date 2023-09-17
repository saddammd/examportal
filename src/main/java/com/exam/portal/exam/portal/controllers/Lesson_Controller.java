package com.exam.portal.exam.portal.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.exam.portal.dto.Add_Lesson_dto;
import com.exam.portal.exam.portal.dto.Lesson_Response_dto;
import com.exam.portal.exam.portal.dto.Response_dto;
import com.exam.portal.exam.portal.entities.Lesson;
import com.exam.portal.exam.portal.services.Lesson_Service;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/examportal")
public class Lesson_Controller {
	
	@Autowired
	private Lesson_Service lesson_service;
	
	@GetMapping("/test")
	public String test() {
			
		return "test success";
	}
	
	@PostMapping("/lesson")
	public ResponseEntity<Lesson> saveLesson(@RequestBody Add_Lesson_dto addLesson) {

		Lesson lesson = new Lesson();
		BeanUtils.copyProperties(addLesson, lesson);
		Lesson save = lesson_service.save(lesson);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(save);		
	}
	
	@GetMapping("/lesson")
	public ResponseEntity<Response_dto> showLessons(){
		
		List<Lesson> showAll = lesson_service.showAll();
		List<Lesson_Response_dto> lesson_response_dto = new ArrayList<Lesson_Response_dto>();
		Response_dto response = new Response_dto();
		
		for(Lesson list: showAll) {
		Lesson_Response_dto lrd = new Lesson_Response_dto();
		BeanUtils.copyProperties(list, lrd);
		lesson_response_dto.add(lrd);
		Map map = new HashMap();
		map.put("content", lesson_response_dto);
		response.setMessage("Lessons Retreived");
		response.setStatus(HttpStatus.ACCEPTED);
		response.setData(map);
		response.setTimestamp(System.currentTimeMillis());
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	@PutMapping("/lesson")
	public ResponseEntity<Lesson> updateLesson(@RequestBody Add_Lesson_dto addLesson) {

		Lesson lesson = new Lesson();
		BeanUtils.copyProperties(addLesson, lesson);
		Lesson save = lesson_service.save(lesson);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(save);		
	}
	
	@DeleteMapping("/lesson/{id}")
	public ResponseEntity<String> deleteLesson(@PathVariable Integer id){
		lesson_service.deleteLesson(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}


}
