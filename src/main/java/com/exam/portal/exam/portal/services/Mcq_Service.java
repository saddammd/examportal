package com.exam.portal.exam.portal.services;

import java.util.List;

import com.exam.portal.exam.portal.entities.Mcq;

public interface Mcq_Service {

	public Mcq add_mcq(Mcq mcq);

	public List<Mcq> findMcqByLessonId(Integer id);
	
	public String deleteMcq(Mcq mcq);

}
