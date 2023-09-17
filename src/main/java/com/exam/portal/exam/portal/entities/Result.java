package com.exam.portal.exam.portal.entities;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
  
  @Entity
  
  @Table(name="result") 
  public class Result {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id") 
  private Integer id;
  
  @Column(name = "question")
	private String question;

	@Column(name = "option1")
	private String option1;

	@Column(name = "option2")
	private String option2;

	@Column(name = "option3")
	private String option3;

	@Column(name = "option4")
	private String option4;

	@Column(name = "answer")
	private String answer;

	@Column(name = "lesson_id")
	private String lessonId;
	
	@Column(name = "question_id")
	private Integer questionId;
	
  
  @Column(name = "submittedAnswer")
  private String submittedAnswer;
  
  
  @ManyToOne
	@JoinColumn(name = "resultcollection_id")
	@JsonBackReference
	private ResultCollection resultcollection;

public ResultCollection getResultcollection() {
	return resultcollection;
}

public void setResultcollection(ResultCollection resultcollection) {
	this.resultcollection = resultcollection;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getSubmittedAnswer() {
	return submittedAnswer;
}

public void setSubmittedAnswer(String submittedAnswer) {
	this.submittedAnswer = submittedAnswer;
}

public String getQuestion() {
	return question;
}

public void setQuestion(String question) {
	this.question = question;
}

public String getOption1() {
	return option1;
}

public void setOption1(String option1) {
	this.option1 = option1;
}

public String getOption2() {
	return option2;
}

public void setOption2(String option2) {
	this.option2 = option2;
}

public String getOption3() {
	return option3;
}

public void setOption3(String option3) {
	this.option3 = option3;
}

public String getOption4() {
	return option4;
}

public void setOption4(String option4) {
	this.option4 = option4;
}

public String getAnswer() {
	return answer;
}

public void setAnswer(String answer) {
	this.answer = answer;
}

public String getLessonId() {
	return lessonId;
}

public void setLessonId(String lessonId) {
	this.lessonId = lessonId;
}

public Integer getQuestionId() {
	return questionId;
}

public void setQuestionId(Integer questionId) {
	this.questionId = questionId;
}



  
  }