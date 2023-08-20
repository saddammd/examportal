package com.exam.portal.exam.portal.dto;

import javax.persistence.Column;

public class Add_Reading_dto {
	
	private Integer lessonId;
	  
	private String title;
	  
	private String imageUrl;
	  
	private String content;
	  
	
	
	public Add_Reading_dto() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Integer getLessonId() {
		return lessonId;
	}




	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}




	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}


	
}
