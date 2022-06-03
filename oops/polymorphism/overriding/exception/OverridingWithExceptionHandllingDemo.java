package com.dhiraj.oops.polymorphism.overriding.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

class Super {

	/** when parent throws checked exception child choose not to throw **/
	public void m1() throws IOException {
	}

	/**
	 * when parent throws checked exception child can throw same exception
	 **/
	public void m2() throws IOException {
	}

	/**
	 * when parent throws checked exception child can throw same or child exception
	 * not a parent exception
	 **/
	public void m3() throws IOException {
	}

	/**
	 * when parent throws checked exception child can throw same or child exception
	 * not a parent exception and any unchecked exception
	 **/
	public void m4() throws IOException {

	}

	/** no rule for child class throwing any Unchecked exception **/
	public void m5() {

	}

}

class Sub extends Super {

	@Override
	public void m1() {
	}

	@Override
	public void m2() throws IOException {
	}

	@Override
	public void m3() throws FileNotFoundException {
	}

	/** child throwing same exception as parent and Unchecked exception **/
	@Override
	public void m4() throws IOException, ArithmeticException {

	}

	/**child throwing unchecked exceptions **/
	@Override
	public void m5() throws ArithmeticException, NullPointerException, ClassCastException, RuntimeException {

	}

}

public class OverridingWithExceptionHandllingDemo {

}
