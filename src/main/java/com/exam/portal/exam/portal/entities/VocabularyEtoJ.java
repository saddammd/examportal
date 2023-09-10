package com.exam.portal.exam.portal.entities;

import java.util.Date;

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

  
  @Entity
  @Table(name="vocabularyEtoJ") 
  public class VocabularyEtoJ {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id") 
  private Integer id;
  
  @Column(name="hiragana_character") 
  private String hiragana_character;
  
  @Column(name="english_character") 
  private String english_character;
  
  @Column(name="kanji_character") 
  private String kanji_character;
  
  @Column(name="romaji_character") 
  private String romaji_character;
  
  @ManyToOne 
  @JoinColumn(name = "lesson_id")
  @JsonBackReference
  private Lesson lesson;
  
  @Temporal(TemporalType.DATE) 
  private Date createdDate;
  
  @Temporal(TemporalType.DATE) 
  private Date updatedDate;

public VocabularyEtoJ() {
	super();
	// TODO Auto-generated constructor stub
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getHiragana_character() {
	return hiragana_character;
}

public void setHiragana_character(String hiragana_character) {
	this.hiragana_character = hiragana_character;
}

public String getEnglish_character() {
	return english_character;
}

public void setEnglish_character(String english_character) {
	this.english_character = english_character;
}

public String getKanji_character() {
	return kanji_character;
}

public void setKanji_character(String kanji_character) {
	this.kanji_character = kanji_character;
}

public String getRomaji_character() {
	return romaji_character;
}

public void setRomaji_character(String romaji_character) {
	this.romaji_character = romaji_character;
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
 