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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
  
  
  @Entity
  
  @Table(name = "video") 
  public class Video {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id") 
  private Integer id;
  
  @Column(name = "url") 
  private String url;
  
  @Column(name = "url2") 
  private String url2;
  
  
  @CreationTimestamp
  @Temporal(TemporalType.DATE)
  private Date createdDate;
  
  @UpdateTimestamp
  @Temporal(TemporalType.DATE)
  private Date updatedDate;
  
  @ManyToOne
  @JoinColumn(name = "lesson_id")
  @JsonBackReference
  private Lesson lesson;

public Video() {
	super();
	// TODO Auto-generated constructor stub
}

public Video(Integer id, String url, Date createdDate, Date updatedDate, Lesson lesson) {
	super();
	this.id = id;
	this.url = url;
	this.createdDate = createdDate;
	this.updatedDate = updatedDate;
	this.lesson = lesson;
}

public Video(String url, Date createdDate, Date updatedDate, Lesson lesson) {
	super();
	this.url = url;
	this.createdDate = createdDate;
	this.updatedDate = updatedDate;
	this.lesson = lesson;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
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
@JsonBackReference
public Lesson getLesson() {
	return lesson;
}

public void setLesson(Lesson lesson) {
	this.lesson = lesson;
}


public String getUrl2() {
	return url2;
}

public void setUrl2(String url2) {
	this.url2 = url2;
}

@Override
public String toString() {
	return "Video [id=" + id + ", url=" + url + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
			+ ", lesson=" + lesson + "]";
}
  
  
  
  
  }
 