package com.exam.portal.exam.portal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.exam.portal.dao.ResultCollection_Repository;
import com.exam.portal.exam.portal.dao.Result_Repository;
import com.exam.portal.exam.portal.entities.Result;
import com.exam.portal.exam.portal.entities.ResultCollection;

@Service
public class ResultCollection_ServiceImpl implements ResultCollection_Service {
	
	@Autowired
	ResultCollection_Repository resultCollection_Repository;
	
	@Autowired
	Result_Repository result_Repository;

	@Override
	public List<ResultCollection> getAllResultCollectionByLessonId(Integer id) {
		return this.resultCollection_Repository.findAllByLessonId(id);
		
	}

	@Override
	public List<Result> getAllResultByResultCollectionId(Integer id) {
		return this.result_Repository.findAllByResultcollectionId(id);
	}

}
