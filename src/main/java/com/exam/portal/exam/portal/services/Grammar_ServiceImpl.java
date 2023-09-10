package com.exam.portal.exam.portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.exam.portal.dao.Grammar_Repository;
import com.exam.portal.exam.portal.dao.Reading_Repository;
import com.exam.portal.exam.portal.entities.Grammar;
import com.exam.portal.exam.portal.entities.Reading;

@Service
public class Grammar_ServiceImpl implements Grammar_Service {
	
	@Autowired
	Grammar_Repository grammar_repository;

	@Override
	public Grammar addGrammar(Grammar grammar) {
		return this.grammar_repository.save(grammar);
	}

	
}
