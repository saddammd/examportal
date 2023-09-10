package com.exam.portal.exam.portal.controllers;

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

import com.exam.portal.exam.portal.dto.Add_Grammar_dto;
import com.exam.portal.exam.portal.dto.Add_Video_dto;
import com.exam.portal.exam.portal.dto.Edit_Video_dto;
import com.exam.portal.exam.portal.entities.Grammar;
import com.exam.portal.exam.portal.entities.Lesson;
import com.exam.portal.exam.portal.entities.Reading;
import com.exam.portal.exam.portal.entities.Video;
import com.exam.portal.exam.portal.services.Grammar_Service;
import com.exam.portal.exam.portal.services.Lesson_Service;
import com.exam.portal.exam.portal.services.Reading_Service;
import com.exam.portal.exam.portal.services.Video_Service;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/grammar")
public class Grammar_Controller {

	@Autowired
	Reading_Service reading_service;
	
	@Autowired
	Grammar_Service grammarService;
	
	@GetMapping("/grammar/{id}")
	public String getVideo(@PathVariable Integer id) {
	return id.toString();	
	}
	
	@PostMapping("/grammar")
	public ResponseEntity<String> addVideo(@RequestBody Add_Grammar_dto addgrammar){
		
		Grammar grammar = new Grammar();
		Reading findReading = reading_service.findReading(addgrammar.getReadingId());
		if(findReading!=null) {
			grammar.setReading(findReading);
			grammar.setContent(addgrammar.getContent());
			grammarService.addGrammar(grammar);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Grammar Added Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Reading Not Found");
		
		
	}
	
}
