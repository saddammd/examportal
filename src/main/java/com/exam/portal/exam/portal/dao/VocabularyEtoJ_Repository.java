package com.exam.portal.exam.portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.exam.portal.entities.Vocabulary;
import com.exam.portal.exam.portal.entities.VocabularyEtoJ;

public interface VocabularyEtoJ_Repository extends JpaRepository<VocabularyEtoJ, Integer>{
	
	public List<VocabularyEtoJ> findVocabularEtoJByLessonId(Integer id);

}
