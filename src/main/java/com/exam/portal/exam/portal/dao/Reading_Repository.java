package com.exam.portal.exam.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.exam.portal.entities.Reading;

public interface Reading_Repository extends JpaRepository<Reading, Integer> {

	public Reading findReadingById(Integer id);

}
