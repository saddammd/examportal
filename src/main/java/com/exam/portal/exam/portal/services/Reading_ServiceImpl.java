package com.exam.portal.exam.portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.exam.portal.dao.Reading_Repository;
import com.exam.portal.exam.portal.entities.Reading;

@Service
public class Reading_ServiceImpl implements Reading_Service {
	
	@Autowired
	Reading_Repository reading_repository;

	@Override
	public Reading addReading(Reading reading) {
		
		return reading_repository.save(reading);
	}

	@Override
	public Reading findReading(Integer id) {
		
		return reading_repository.findReadingById(id);
	}

	@Override
	public String deleteReading(Reading reading) {
		
		reading_repository.delete(reading);
		
			return "Reading section deleted successfully";
	}

}
