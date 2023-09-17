package com.exam.portal.exam.portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.portal.exam.portal.entities.Result;
import com.exam.portal.exam.portal.entities.ResultCollection;


public interface ResultCollection_Repository extends JpaRepository<ResultCollection, Integer>{
	
	public List<ResultCollection> findAllByLessonId(Integer id);

}
