package com.dhiraj.oops.polymorphism.overriding.varargs;

class Super {

	/**
	 * var-arg method must be overridden as var-args else that will be overloading
	 * and not overriding
	 **/
	public void m1(int... i) {
		System.out.println("Parent :: m1 -> i : " + i);
	}

	public void m2(int... i) {
		System.out.println("Parent :: m2 -> i : " + i);
	}
}

class Sub extends Super {

	/*
	 * @Override public void m1(int i) {
	 * 
	 * } // CE:
	 */

	@Override
	public void m2(int... i) {
		System.out.println("Child :: m2 -> i : " + i);
	}

}

public class OverridingWithVarargsMethodDemo {
	public static void main(String[] args) {

	}
}
