package com.dhiraj.design_patterns.singleton.breaking.reflection.solution.exception;

/** throwing exception from private constructor **/
public class SingletonThrowingException {

	private static SingletonThrowingException singleton = null;

	private SingletonThrowingException() throws RuntimeException {
		if (singleton != null)
			throw new RuntimeException("Not Allowed");
	}

	public static SingletonThrowingException getInstance() {
		if (singleton == null) {
			singleton = new SingletonThrowingException();
		}
		return singleton;
	}
}