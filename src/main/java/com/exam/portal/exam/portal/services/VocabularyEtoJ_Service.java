package com.exam.portal.exam.portal.services;

import com.exam.portal.exam.portal.entities.VocabularyEtoJ;

public interface VocabularyEtoJ_Service {

	public VocabularyEtoJ addVocabulary(VocabularyEtoJ vocabs);

	public VocabularyEtoJ findVocabulary(Integer id);

	public String deleteVocabularyEtoJ(VocabularyEtoJ vocabs);

}
