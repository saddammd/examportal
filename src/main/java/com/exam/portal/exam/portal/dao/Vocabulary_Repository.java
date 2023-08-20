package com.exam.portal.exam.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.exam.portal.entities.Vocabulary;

public interface Vocabulary_Repository extends JpaRepository<Vocabulary, Integer>{
	
	public Vocabulary findVocabularById(Integer id);

}
