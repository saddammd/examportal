package com.exam.portal.exam.portal.dto;

public class Edit_Lesson_dto {
	
		private Integer id;
		private String name;
		
		
		
		
		public Edit_Lesson_dto() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Edit_Lesson_dto(Integer id, String name) {
			super();
			this.id = id;
			this.name = name;
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
		
		
		
		}
