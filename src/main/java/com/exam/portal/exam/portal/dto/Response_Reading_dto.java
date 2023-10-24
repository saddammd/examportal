package com.exam.portal.exam.portal.dto;

import java.util.List;

import javax.persistence.Column;

import com.exam.portal.exam.portal.entities.Grammar;



public class Response_Reading_dto {
	
	private Integer id;
	
	private Integer lessonId;
	  
	private String heading;
	
	private String subheading;
	  
	private String imageUrl;
	  
	private String content;
	  
	
	
	
	public Response_Reading_dto() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Integer getLessonId() {
		return lessonId;
	}




	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}






	public String getHeading() {
		return heading;
	}




	public void setHeading(String heading) {
		this.heading = heading;
	}




	public String getSubheading() {
		return subheading;
	}




	public void setSubheading(String subheading) {
		this.subheading = subheading;
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




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}
	
	

	
}
