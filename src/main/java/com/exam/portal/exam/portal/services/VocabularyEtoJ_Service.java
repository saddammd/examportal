package com.exam.portal.exam.portal.services;

import java.util.List;

import com.exam.portal.exam.portal.entities.VocabularyEtoJ;

public interface VocabularyEtoJ_Service {

	public VocabularyEtoJ addVocabulary(VocabularyEtoJ vocabs);

	public List<VocabularyEtoJ> findVocabularyEtoJByLessonId(Integer id);

	public String deleteVocabularyEtoJ(VocabularyEtoJ vocabs);

}
