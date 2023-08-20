package com.exam.portal.exam.portal.services;

import com.exam.portal.exam.portal.entities.Reading;

public interface Reading_Service {

	public Reading addReading(Reading reading);

	public Reading findReading(Integer id);

	public String deleteReading(Reading reading);

}
