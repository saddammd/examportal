package com.exam.portal.exam.portal.dto;

import java.util.Map;

import org.springframework.http.HttpStatus;

public class Response_dto {
	
	private Map<?, ?> data;
	private HttpStatus status;
	private String message;
	private Long timestamp;
	
	
	public Response_dto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Map<?, ?> getData() {
		return data;
	}


	public void setData(Map<?, ?> data) {
		this.data = data;
	}


	public HttpStatus getStatus() {
		return status;
	}


	public void setStatus(HttpStatus status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	
	

}
