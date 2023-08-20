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
@Table(name="lesson")
public class Lesson {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "lesson")
	@JsonManagedReference
	private List<Video> video;
	
	@OneToMany(mappedBy = "lesson")
	@JsonManagedReference
	private List<Mcq> mcq;
	
	@OneToMany(mappedBy = "lesson")
	 @JsonManagedReference
	private List<Reading> reading;
	
	@OneToMany(mappedBy = "lesson")
	 @JsonManagedReference
	private List<Vocabulary> vocabulary;
	
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Temporal(TemporalType.DATE)
	private Date updatedDate;

	public Lesson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lesson(Integer id, String name, Date createdDate, Date updatedDate) {
		super();
		this.id = id;
		this.name = name;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Lesson(String name, Date createdDate, Date updatedDate) {
		super();
		this.name = name;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
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
	
	@JsonManagedReference
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

	@Override
	public String toString() {
		return "Lesson [id=" + id + ", name=" + name + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}

	
	
}
