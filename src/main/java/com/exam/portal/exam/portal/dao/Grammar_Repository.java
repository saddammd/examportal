package com.exam.portal.exam.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.exam.portal.entities.Grammar;
import com.exam.portal.exam.portal.entities.Reading;

public interface Grammar_Repository extends JpaRepository<Grammar, Integer> {

	public Grammar findGrammarById(Integer id);

}
