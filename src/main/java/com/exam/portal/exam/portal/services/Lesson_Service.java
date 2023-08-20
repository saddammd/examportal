package com.exam.portal.exam.portal.services;

import java.util.List;

import com.exam.portal.exam.portal.entities.Lesson;


public interface Lesson_Service {

	public Lesson save(Lesson lesson);
	public List<Lesson> showAll();
	public String deleteLesson(Integer id);
	public Lesson findLesson(Integer id);
}
