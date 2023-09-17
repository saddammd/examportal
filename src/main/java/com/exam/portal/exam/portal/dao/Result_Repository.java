package com.exam.portal.exam.portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.exam.portal.entities.Result;

public interface Result_Repository extends JpaRepository<Result, Integer>{
	
	public List<Result> findAllByLessonIdAndResultcollectionId(Integer lessonid, Integer resultcollectionid);

	public List<Result> findAllByResultcollectionId(Integer id);

}
