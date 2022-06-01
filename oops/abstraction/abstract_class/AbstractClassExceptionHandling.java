package com.dhiraj.oops.abstraction.abstract_class;

import java.io.FileNotFoundException;
import java.io.IOException;

abstract class SomeClass {
	abstract void m1() throws IOException;
}

class C1 extends SomeClass {

	@Override
	// can throw same exception
	void m1() throws IOException {
		System.out.println("C1::m1");
	}
}

class C2 extends SomeClass {

	@Override
	// choose not to throw any exception
	void m1() {
		System.out.println("C2::m1");
	}
}

class C3 extends SomeClass {

	@Override
	// void m1() throws Exception{ --> Cannot throw super type
	void m1() {
		System.out.println("C3::m1");
	}
}

class C4 extends SomeClass {

	@Override
	// can throw sub type of exception
	void m1() throws FileNotFoundException {
		System.out.println("C4::m1");
	}
}

public class AbstractClassExceptionHandling {
	public static void main(String[] args) {

	}
}
