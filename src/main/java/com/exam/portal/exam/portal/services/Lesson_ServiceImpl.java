package com.exam.portal.exam.portal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.exam.portal.exam.portal.dao.Lesson_Repository;
import com.exam.portal.exam.portal.entities.Lesson;

@Service
public class Lesson_ServiceImpl implements Lesson_Service {

	@Autowired
	Lesson_Repository lesson_repository;
	
	@Override
	public Lesson save(Lesson lesson) {
		
		return lesson_repository.save(lesson);
	}

	@Override
	public List<Lesson> showAll() {
		
		List<Lesson> findAll = lesson_repository.findAll();
		
		return findAll;
	}

	@Override
	public String deleteLesson(Integer id) {
	
		lesson_repository.deleteById(id);
		
		return HttpStatus.OK.toString();
	}

	@Override
	public Lesson findLesson(Integer id) {
		return lesson_repository.findLessonById(id);
	}

}
