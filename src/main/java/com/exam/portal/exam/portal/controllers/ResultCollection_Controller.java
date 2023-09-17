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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.exam.portal.dto.Lesson_Response_dto;
import com.exam.portal.exam.portal.dto.Response_dto;
import com.exam.portal.exam.portal.dto.ResultCollection_Response_dto;
import com.exam.portal.exam.portal.dto.ResultResponse_dto;
import com.exam.portal.exam.portal.dto.Result_dto;
import com.exam.portal.exam.portal.entities.Lesson;
import com.exam.portal.exam.portal.entities.Result;
import com.exam.portal.exam.portal.entities.ResultCollection;
import com.exam.portal.exam.portal.services.ResultCollection_Service;

@RestController
@RequestMapping("/resultCollection")
@CrossOrigin(origins = "http://localhost:4200")
public class ResultCollection_Controller {
	
	@Autowired
	ResultCollection_Service resultCollection_Service;
	

	@GetMapping("/result/{id}")
	public ResponseEntity<ResultResponse_dto> showResultCollections(@PathVariable Integer id){
		
		List<ResultCollection> showAll = resultCollection_Service.getAllResultCollectionByLessonId(id);
		List<ResultCollection_Response_dto> resultCollection_response_dto = new ArrayList<ResultCollection_Response_dto>();
		ResultResponse_dto response = new ResultResponse_dto();
		
		for(ResultCollection list: showAll) {
			ResultCollection_Response_dto lrd = new ResultCollection_Response_dto();
		BeanUtils.copyProperties(list, lrd);
		resultCollection_response_dto.add(lrd);
		Map map = new HashMap();
		map.put("content", resultCollection_response_dto);
		response.setMessage("Result Collection Retreived");
		response.setStatus(HttpStatus.ACCEPTED);
		response.setResultResponse(map);
		response.setTimestamp(System.currentTimeMillis());
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/resultdetails/{id}")
	public ResponseEntity<ResultResponse_dto> showResultByResultCollectionid(@PathVariable Integer id){
		
		List<Result> showAll = resultCollection_Service.getAllResultByResultCollectionId(id);
		List<Result_dto> result_dtoList = new ArrayList<Result_dto>();
		ResultResponse_dto response = new ResultResponse_dto();
		
		for(Result list: showAll) {
			Result_dto lrd = new Result_dto();
		BeanUtils.copyProperties(list, lrd);
		result_dtoList.add(lrd);
		Map map = new HashMap();
		map.put("content", result_dtoList);
		response.setMessage("Result Collection Retreived");
		response.setStatus(HttpStatus.ACCEPTED);
		response.setResultResponse(map);
		response.setTimestamp(System.currentTimeMillis());
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
}