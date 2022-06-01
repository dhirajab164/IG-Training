package com.dhiraj.oops.inheritance.type.multiple;

interface A {
	void printA();
}

interface B {
	void printB();
}

public class MultipleInheritanceDemo implements A, B {

	@Override
	public void printB() {
		System.out.println("A");
	}

	@Override
	public void printA() {
		System.out.println("B");
	}

	public static void main(String[] args) {
		MultipleInheritanceDemo mi = new MultipleInheritanceDemo();
		mi.printA();
		mi.printB();
	}

}
