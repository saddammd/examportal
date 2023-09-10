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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.exam.portal.dto.Add_Mcq_dto;
import com.exam.portal.exam.portal.dto.Edit_Mcq_dto;
import com.exam.portal.exam.portal.dto.Result_dto;
import com.exam.portal.exam.portal.entities.Lesson;
import com.exam.portal.exam.portal.entities.Mcq;
import com.exam.portal.exam.portal.entities.Result;
import com.exam.portal.exam.portal.entities.ResultCollection;
import com.exam.portal.exam.portal.services.Lesson_Service;
import com.exam.portal.exam.portal.services.Mcq_Service;
import com.exam.portal.exam.portal.services.Result_Service;

@RestController
@RequestMapping("/result")
@CrossOrigin(origins = "http://localhost:9200")
public class Result_Controller {
	
	@Autowired
	Result_Service result_service;
	
	@GetMapping("/result")
	public String test() {
		return "result";
	}
	
	@PostMapping("/result")
	public ResponseEntity<String> submitResult(@RequestBody List<Result_dto> submitResult){
		
		List<Result> resultList = new ArrayList<Result>();
		ResultCollection rc = new ResultCollection();
		for(Result_dto r : submitResult) {
			//BeanUtils.copyProperties(r, result);
			Result result = new Result();
			result.setAnswer(r.getAnswer());
			result.setLessonId(r.getLessonId());
			result.setOption1(r.getOption1());
			result.setOption2(r.getOption2());
			result.setOption3(r.getOption3());
			result.setOption4(r.getOption4());
			result.setQuestion(r.getQuestion());
			result.setSubmittedAnswer(r.getSubmittedAnswer());
			result.setQuestionId(r.getQuestionId()+1);
			result.setResultcollection(rc);
			resultList.add(result);
		}
		
		String submitResult2 = result_service.submitResult(resultList, rc);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(submitResult2);
		
		
	}
	
}
