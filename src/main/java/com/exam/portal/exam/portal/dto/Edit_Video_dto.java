package com.exam.portal.exam.portal.dto;

public class Edit_Video_dto {
	
	private Integer lessonId;
	private Integer id;
	private String url;
	
	public Edit_Video_dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getLessonId() {
		return lessonId;
	}
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
