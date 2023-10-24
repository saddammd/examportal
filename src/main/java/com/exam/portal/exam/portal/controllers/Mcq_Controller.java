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

import com.exam.portal.exam.portal.dto.Add_Mcq_dto;
import com.exam.portal.exam.portal.dto.Edit_Mcq_dto;
import com.exam.portal.exam.portal.dto.Mcq_Response_dto;
import com.exam.portal.exam.portal.dto.Response_dto;
import com.exam.portal.exam.portal.entities.Lesson;
import com.exam.portal.exam.portal.entities.Mcq;
import com.exam.portal.exam.portal.services.Lesson_Service;
import com.exam.portal.exam.portal.services.Mcq_Service;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mcq")
public class Mcq_Controller {
	
	@Autowired
	Lesson_Service lessonService;
	
	@Autowired
	private Mcq_Service mcq_Service;
	
	
	@GetMapping("/mcq/{id}")
	public ResponseEntity<List<Mcq_Response_dto>> listMcq(@PathVariable Integer id) {

	    List<Mcq_Response_dto> listmcqResponse = new ArrayList<Mcq_Response_dto>();
	    
	    Lesson findLesson = lessonService.findLesson(id);
	    List<Mcq> findmcq = mcq_Service.findMcqByLessonId(id);
	    
	    if (findmcq != null) {
	        for (Mcq mcq : findmcq) {
	            Mcq_Response_dto dto = new Mcq_Response_dto();
	            BeanUtils.copyProperties(mcq, dto); // Copy properties from 'mcq' to 'dto'
	            dto.setLesson_id(id);
	            listmcqResponse.add(dto);
	        }
	    }

	    return ResponseEntity.status(HttpStatus.OK).body(listmcqResponse);
	}

	
	@PostMapping("/mcq")
	public ResponseEntity<Mcq_Response_dto> addMcq(@RequestBody Add_Mcq_dto addMcqdto){
		
		Mcq mcq = new Mcq();
		Mcq_Response_dto mcq_response_dto = new Mcq_Response_dto();
		
		Lesson findLesson = lessonService.findLesson(addMcqdto.getLesson_id());
		if(findLesson!=null) {
			mcq.setLesson(findLesson);
			BeanUtils.copyProperties(addMcqdto, mcq);
			Mcq added_mcq = mcq_Service.add_mcq(mcq);
			BeanUtils.copyProperties(added_mcq, mcq_response_dto);
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(mcq_response_dto);
		}
		return null;
		
		
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
	
	/*
	 * @DeleteMapping("/mcq/{id}") public ResponseEntity<String>
	 * delteMcq(@PathVariable Integer id){
	 * 
	 * 
	 * Mcq mcq = mcq_Service.findMcqByLessonId(id); String mcqString =
	 * mcq_Service.deleteMcq(mcq); return
	 * ResponseEntity.status(HttpStatus.OK).body(mcqString);
	 * 
	 * 
	 * }
	 */	


}
