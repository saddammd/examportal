package com.exam.portal.exam.portal.dto;

import java.util.List;

import com.exam.portal.exam.portal.entities.Result;

public class ResultCollection_Response_dto {
	
	private Integer id;
	  
	private String createdDate;
	
	private Integer lessonId;
	
	private List<Result> result;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public List<Result> getResult() {
		return result;
	}

	public void setResult(List<Result> result) {
		this.result = result;
	}

	public Integer getLessonId() {
		return lessonId;
	}

	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}


	
	
	
	

}
