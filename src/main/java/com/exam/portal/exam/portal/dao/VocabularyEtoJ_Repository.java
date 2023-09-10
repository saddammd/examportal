package com.exam.portal.exam.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.exam.portal.entities.Vocabulary;
import com.exam.portal.exam.portal.entities.VocabularyEtoJ;

public interface VocabularyEtoJ_Repository extends JpaRepository<VocabularyEtoJ, Integer>{
	
	public VocabularyEtoJ findVocabularById(Integer id);

}
