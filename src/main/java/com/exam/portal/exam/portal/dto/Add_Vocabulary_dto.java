package com.exam.portal.exam.portal.dto;

import javax.persistence.Column;

public class Add_Vocabulary_dto {
	
	private Integer lessonId;
	  private String hiragana_character;
	  private String english_character;
	  private String kanji_character;
	  private String romaji_character;
	
	
	public Add_Vocabulary_dto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getLessonId() {
		return lessonId;
	}


	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
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


}
