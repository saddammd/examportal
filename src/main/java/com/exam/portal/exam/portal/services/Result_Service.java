package com.exam.portal.exam.portal.services;

import java.util.List;

import com.exam.portal.exam.portal.entities.Result;
import com.exam.portal.exam.portal.entities.ResultCollection;

public interface Result_Service {

	public String submitResult(List<Result> result, ResultCollection rc);
	
	public List<Result> findResultByLessonIdAndResultCollection(Integer lessonid, Integer resultcollectionid);
}
