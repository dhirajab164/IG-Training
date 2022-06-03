package com.dhiraj.oops.polymorphism.overriding.abstract_method;

abstract class Super {

	abstract void m1();

	/** non-abstract can be overridden as abstract **/
	public void m2() {
		System.out.println("Super::m2");
	}

}

class Sub extends Super {

	@Override
	void m1() {
		System.out.println("Sub :: m1");

	}
}

abstract class Child extends Super {

	@Override
	void m1() {
		System.out.println("Child::m1");

	}

	abstract public void m2();

}

public class OverridingAbstractMethodDemo {

}
