package com.exam.portal.exam.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.exam.portal.entities.Lesson;

public interface Lesson_Repository extends JpaRepository<Lesson, Integer> {

	public Lesson findLessonById(Integer id);
}
