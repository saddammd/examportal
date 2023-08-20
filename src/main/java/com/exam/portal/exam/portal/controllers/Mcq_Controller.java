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

import com.exam.portal.exam.portal.dto.Add_Mcq_dto;
import com.exam.portal.exam.portal.dto.Edit_Mcq_dto;
import com.exam.portal.exam.portal.entities.Lesson;
import com.exam.portal.exam.portal.entities.Mcq;
import com.exam.portal.exam.portal.services.Lesson_Service;
import com.exam.portal.exam.portal.services.Mcq_Service;

@RestController
@RequestMapping("/mcq")
public class Mcq_Controller {
	
	@Autowired
	Lesson_Service lessonService;
	
	@Autowired
	private Mcq_Service mcq_Service;
	
	@PostMapping("/mcq")
	public ResponseEntity<String> addMcq(@RequestBody Add_Mcq_dto addMcqdto){
		
		Mcq mcq = new Mcq();
		Lesson findLesson = lessonService.findLesson(addMcqdto.getLesson_id());
		if(findLesson!=null) {
			mcq.setLesson(findLesson);
			BeanUtils.copyProperties(addMcqdto, mcq);
			mcq_Service.add_mcq(mcq);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Mcq Added Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Lesson Not Found");
		
		
	}
	
	@PutMapping("/mcq")
	public ResponseEntity<String> editMcq(@RequestBody Edit_Mcq_dto editMcqdto){
		
		Mcq mcq = new Mcq();
		Lesson findLesson = lessonService.findLesson(editMcqdto.getLesson_id());
		if(findLesson!=null) {
			mcq.setLesson(findLesson);
			BeanUtils.copyProperties(editMcqdto, mcq);
			mcq_Service.add_mcq(mcq);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Mcq details edited Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Lesson Not Found");
		
		
	}
	
	@DeleteMapping("/mcq/{id}")
	public ResponseEntity<String> delteMcq(@PathVariable Integer id){
		
	    Mcq mcq = mcq_Service.findMcqById(id);
		String mcqString = mcq_Service.deleteMcq(mcq);
		return ResponseEntity.status(HttpStatus.OK).body(mcqString);
		
		
	}
	


}
