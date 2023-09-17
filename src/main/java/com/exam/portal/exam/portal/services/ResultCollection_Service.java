package com.exam.portal.exam.portal.services;

import java.util.List;

import com.exam.portal.exam.portal.entities.Result;
import com.exam.portal.exam.portal.entities.ResultCollection;

public interface ResultCollection_Service {
	
	public List<ResultCollection> getAllResultCollectionByLessonId(Integer id);

	public List<Result> getAllResultByResultCollectionId(Integer id);

}
