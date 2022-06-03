package com.dhiraj.oops.polymorphism.overriding.access_modifiers;

class Super {

	/** public -> public **/
	public void publicMethod() {
		System.out.println("Super::publicMethod");
	}

	/** protected -> protected / public **/
	protected void protectedMethod() {
		System.out.println("Super::protectedMethod");
	}

	/** default -> default / protected / public **/
	void defaultMethod() {
		System.out.println("Super::defaultMethod");
	}

	/** private -> not available **/
	private void privateMethod() {
		System.out.println("Super::privateMethod");
	}

}

class Sub extends Super {

	@Override
	public void publicMethod() {
	}

	@Override
	protected void protectedMethod() {
		System.out.println("Sub::protectedMethod");
	}

	@Override
	void defaultMethod() {
		System.out.println("Sub::defaultMethod");
	}

}

public class OverridingWithAccessModifiersDemo {

}
