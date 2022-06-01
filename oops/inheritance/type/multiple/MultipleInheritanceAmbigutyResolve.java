package com.dhiraj.oops.inheritance.type.multiple;

interface C {
	void print();

}

interface D {
	void print();
}

interface E extends C, D {

}

public class MultipleInheritanceAmbigutyResolve implements E {

	@Override
	public void print() {
		System.out.println("Hello");

	}

}
