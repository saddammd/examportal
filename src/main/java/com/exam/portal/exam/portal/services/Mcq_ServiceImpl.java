package com.exam.portal.exam.portal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.exam.portal.dao.Mcq_Repository;
import com.exam.portal.exam.portal.entities.Mcq;

@Service
public class Mcq_ServiceImpl implements Mcq_Service {

	
	@Autowired
	private Mcq_Repository mcq_repository;
	
	@Override
	public Mcq add_mcq(Mcq mcq) {
		
		return mcq_repository.save(mcq);
	}

	@Override
	public List<Mcq> findMcqByLessonId(Integer id) {
		
		return mcq_repository.findMcqByLessonId(id);
	}

	@Override
	public String deleteMcq(Mcq mcq) {
		mcq_repository.delete(mcq);
		return "Mcq Deleted Successfully";
	}

}
