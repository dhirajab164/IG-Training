package com.dhiraj.app.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public BusinessException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
