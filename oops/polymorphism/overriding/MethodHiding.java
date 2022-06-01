package com.dhiraj.oops.polymorphism.overriding;

class Parent {
	public static void thisMethod() {
		System.out.println("Parent class method");
	}
}

class Child extends Parent {
	public static void thisMethod() {
		System.out.println("Child class method");
	}
}

public class MethodHiding {

	public static void main(String[] args) {

		Parent.thisMethod(); // Parent class method

		Child.thisMethod(); // Child class method

		Parent pc = new Child();
		pc.thisMethod(); // Parent class method | if non static -> Child class method

	}

}
