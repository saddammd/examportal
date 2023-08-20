package com.exam.portal.exam.portal.dto;

import java.util.Date;
import java.util.List;

import com.exam.portal.exam.portal.entities.Mcq;
import com.exam.portal.exam.portal.entities.Reading;
import com.exam.portal.exam.portal.entities.Video;
import com.exam.portal.exam.portal.entities.Vocabulary;

public class Lesson_Response_dto {
	
private Integer id;
	
	private String name;
	
	private List<Video> video;
	
	private List<Mcq> mcq;
	
	private List<Reading> reading;
	
	private List<Vocabulary> vocabulary;
	
	private Date createdDate;
	
	private Date updatedDate;

	public Lesson_Response_dto() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
