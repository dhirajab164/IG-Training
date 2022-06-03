package com.dhiraj.oops.polymorphism.overriding.static_method;

class Super {

	/** static methods cannot be overridden as static or non-static **/
	static void m1() {
	}

	/** non static method cannot be overridden as static **/
	void m2() {

	}
}

class Sub extends Super {

	@Override
	void m2() {

	}

}

public class OverridingWithStaticMethodDemo {

}
