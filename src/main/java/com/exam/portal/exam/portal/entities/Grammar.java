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
  @Table(name="grammar") 
  public class Grammar {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id") 
  private Integer id;
  
  
  @Column(name="content") 
  private String content;
  
  @ManyToOne
  @JoinColumn(name = "reading_id")
  @JsonBackReference
  private Reading reading;
  
    
public Grammar() {
	super();
	// TODO Auto-generated constructor stub
}


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public String getContent() {
	return content;
}


public void setContent(String content) {
	this.content = content;
}


public Reading getReading() {
	return reading;
}


public void setReading(Reading reading) {
	this.reading = reading;
}
 


  }
 