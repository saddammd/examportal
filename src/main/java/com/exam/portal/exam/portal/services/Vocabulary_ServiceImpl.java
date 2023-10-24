package com.exam.portal.exam.portal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.exam.portal.dao.Vocabulary_Repository;
import com.exam.portal.exam.portal.entities.Vocabulary;

@Service
public class Vocabulary_ServiceImpl implements Vocabulary_Service {
	
	@Autowired
	Vocabulary_Repository vocabulary_repository;

	@Override
	public Vocabulary addVocabulary(Vocabulary vocabs) {
		
		return vocabulary_repository.save(vocabs);
	}

	@Override
	public List<Vocabulary> findVocabularyByLessonId(Integer id) {
		
		return vocabulary_repository.findVocabularByLessonId(id);
	}

	@Override
	public String deleteVocabulary(Vocabulary vocabs) {
		
		vocabulary_repository.delete(vocabs);
		
		return "Vocabulary deleted successfully";
	}

}
