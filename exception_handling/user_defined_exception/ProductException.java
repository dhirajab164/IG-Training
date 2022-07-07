package com.dhiraj.exception_handling.user_defined_exception;

public class ProductException extends RuntimeException {

	public ProductException() {
		super();
	}

	public ProductException(String message) {
		super(message);
	}

}
