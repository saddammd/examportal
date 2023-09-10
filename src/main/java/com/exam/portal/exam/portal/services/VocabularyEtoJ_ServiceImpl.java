package com.exam.portal.exam.portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.exam.portal.dao.VocabularyEtoJ_Repository;
import com.exam.portal.exam.portal.dao.Vocabulary_Repository;
import com.exam.portal.exam.portal.entities.Vocabulary;
import com.exam.portal.exam.portal.entities.VocabularyEtoJ;

@Service
public class VocabularyEtoJ_ServiceImpl implements VocabularyEtoJ_Service {
	
	@Autowired
	VocabularyEtoJ_Repository vocabularyEtoJ_repository;

	@Override
	public VocabularyEtoJ addVocabulary(VocabularyEtoJ vocabs) {
		
		return vocabularyEtoJ_repository.save(vocabs);
	}

	@Override
	public VocabularyEtoJ findVocabulary(Integer id) {
		
		return vocabularyEtoJ_repository.findVocabularById(id);
	}

	@Override
	public String deleteVocabularyEtoJ(VocabularyEtoJ vocabs) {
		
		vocabularyEtoJ_repository.delete(vocabs);
		
		
		return "Vocabulary deleted successfully";
	}

}
