package com.dhiraj.app.exception;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int statusCode;
	private LocalDate timestamp;
	private String message, description;

	public ResourceNotFoundException(int statusCode, LocalDate timestamp, String message, String description) {
		super();
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}

	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	

}
