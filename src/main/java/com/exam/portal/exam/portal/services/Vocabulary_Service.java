package com.exam.portal.exam.portal.services;

import java.util.List;

import com.exam.portal.exam.portal.entities.Vocabulary;

public interface Vocabulary_Service {

	public Vocabulary addVocabulary(Vocabulary vocabs);

	public List<Vocabulary> findVocabularyByLessonId(Integer id);

	public String deleteVocabulary(Vocabulary vocabs);

}
