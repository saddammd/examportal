package com.exam.portal.exam.portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.exam.portal.entities.Mcq;

public interface Mcq_Repository extends JpaRepository<Mcq, Integer> {

	public List<Mcq> findMcqByLessonId(Integer id);
}
