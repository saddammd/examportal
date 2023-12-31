package com.exam.portal.exam.portal.entities;

  
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

  
  @Entity  
  @Table(name="reading") 
  public class Reading {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id") private Integer id;
  
  @Column(name="heading") 
  private String heading;
  
  @Column(name="subheading") 
  private String subheading;
  
  @Column(name="imageUrl") 
  private String imageUrl;
  
  @Column(name="content") 
  private String content;
  
  @OneToMany(mappedBy = "reading")
  @JsonManagedReference
  private List<Grammar> grammar;
  
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

public List<Grammar> getGrammar() {
	return grammar;
}

public void setGrammar(List<Grammar> grammar) {
	this.grammar = grammar;
}

 
  
  
  }
 