package com.exam.portal.exam.portal.services;

import com.exam.portal.exam.portal.entities.Mcq;

public interface Mcq_Service {

	public Mcq add_mcq(Mcq mcq);

	public Mcq findMcqById(Integer id);
	
	public String deleteMcq(Mcq mcq);

}
