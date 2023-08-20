package com.exam.portal.exam.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.exam.portal.entities.Mcq;

public interface Mcq_Repository extends JpaRepository<Mcq, Integer> {

	public Mcq findMcqById(Integer id);
}
