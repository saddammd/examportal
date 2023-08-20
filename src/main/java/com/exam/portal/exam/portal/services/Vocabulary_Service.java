package com.exam.portal.exam.portal.services;

import com.exam.portal.exam.portal.entities.Vocabulary;

public interface Vocabulary_Service {

	public Vocabulary addVocabulary(Vocabulary vocabs);

	public Vocabulary findVocabulary(Integer id);

	public String deleteVocabulary(Vocabulary vocabs);

}
