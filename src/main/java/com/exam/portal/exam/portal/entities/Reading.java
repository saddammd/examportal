package com.exam.portal.exam.portal.entities;

  
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

  
  @Entity  
  @Table(name="reading") 
  public class Reading {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id") private Integer id;
  
  @Column(name="title") 
  private String title;
  
  @Column(name="imageUrl") 
  private String imageUrl;
  
  @Column(name="content") 
  private String content;
  
    
  @ManyToOne
  @JoinColumn(name = "lesson_id")
  @JsonBackReference
  private Lesson lesson;
  
  @Temporal(TemporalType.DATE) 
  private Date createdDate;
  
  @Temporal(TemporalType.DATE) 
  private Date updatedDate;

public Reading() {
	super();
	// TODO Auto-generated constructor stub
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
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

public Lesson getLesson() {
	return lesson;
}

public void setLesson(Lesson lesson) {
	this.lesson = lesson;
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
 