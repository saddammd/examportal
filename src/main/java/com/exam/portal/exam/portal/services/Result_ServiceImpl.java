package com.exam.portal.exam.portal.services;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.exam.portal.dao.Reading_Repository;
import com.exam.portal.exam.portal.dao.ResultCollection_Repository;
import com.exam.portal.exam.portal.dao.Result_Repository;
import com.exam.portal.exam.portal.entities.Reading;
import com.exam.portal.exam.portal.entities.Result;
import com.exam.portal.exam.portal.entities.ResultCollection;

@Service
public class Result_ServiceImpl implements Result_Service {
	
	@Autowired
	Result_Repository result_repository;

	@Autowired
	ResultCollection_Repository resultCollection_Repository;
	
	ResultCollection rc;
	
	@Override
	public List<Result> findResultByLessonIdAndResultCollection(Integer lessonid, Integer resultcollecionid) {

		return this.result_repository.findAllByLessonIdAndResultcollectionId(lessonid, resultcollecionid);
	}

	@Override
	public String submitResult(List<Result> result, ResultCollection rc) {
	
		rc.setCreatedDate(this.calculateTime());
		this.resultCollection_Repository.save(rc);
		this.result_repository.saveAll(result);
		
		
		return "saved";
	}

	private String calculateTime() {
		 ZoneId istZone = ZoneId.of("Asia/Kolkata");

	        // Get the current date and time in IST
	        ZonedDateTime currentIST = ZonedDateTime.now(istZone);

	        // Define the desired date and time format
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	        // Format the current date and time using the specified format
	        String formattedDateTime = currentIST.format(formatter);
	        
	        return formattedDateTime;

	    }
	}
	
