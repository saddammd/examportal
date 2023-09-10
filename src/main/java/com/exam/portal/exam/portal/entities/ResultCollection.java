package com.exam.portal.exam.portal.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
  
  @Entity
  
  @Table(name="resultcollection") 
  public class ResultCollection {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id") 
  private Integer id;
  
  
  @OneToMany(mappedBy = "resultcollection")
	@JsonManagedReference
	private List<Result> result;
  
  @Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Temporal(TemporalType.DATE)
	private Date updatedDate;


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

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public List<Result> getResult() {
	return result;
}

public void setResult(List<Result> result) {
	this.result = result;
}
 
  
  }