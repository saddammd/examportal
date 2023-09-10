package com.exam.portal.exam.portal.services;

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
	
		this.resultCollection_Repository.save(rc);
		this.result_repository.saveAll(result);
		
		
		return "saved";
	}

	
}
