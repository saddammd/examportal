package com.exam.portal.exam.portal.dto;

import java.util.Map;

import org.springframework.http.HttpStatus;

public class ResultResponse_dto {
	
	private Map<?, ?> resultResponse;
	private HttpStatus status;
	private String message;
	private Long timestamp;
	
	
	public ResultResponse_dto() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Map<?, ?> getResultResponse() {
		return resultResponse;
	}




	public void setResultResponse(Map<?, ?> resultResponse) {
		this.resultResponse = resultResponse;
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
