package com.exam.portal.exam.portal.dto;

import java.util.List;

import com.exam.portal.exam.portal.entities.Mcq;
import com.exam.portal.exam.portal.entities.Reading;
import com.exam.portal.exam.portal.entities.Video;
import com.exam.portal.exam.portal.entities.Vocabulary;
import com.exam.portal.exam.portal.entities.VocabularyEtoJ;

public class Add_Video_dto {

	private Integer id;
	
	private String name;
	
	private List<Video> video;
	
	private List<Mcq> mcq;
	
	private List<Reading> reading;
	
	private List<Vocabulary> vocabulary;
	
	private List<VocabularyEtoJ> vocabularyetoj;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}

	public List<Mcq> getMcq() {
		return mcq;
	}

	public void setMcq(List<Mcq> mcq) {
		this.mcq = mcq;
	}

	public List<Reading> getReading() {
		return reading;
	}

	public void setReading(List<Reading> reading) {
		this.reading = reading;
	}

	public List<Vocabulary> getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(List<Vocabulary> vocabulary) {
		this.vocabulary = vocabulary;
	}

	public List<VocabularyEtoJ> getVocabularyetoj() {
		return vocabularyetoj;
	}

	public void setVocabularyetoj(List<VocabularyEtoJ> vocabularyetoj) {
		this.vocabularyetoj = vocabularyetoj;
	}
	
	
	
}
