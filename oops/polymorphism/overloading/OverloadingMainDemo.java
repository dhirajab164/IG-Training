package com.dhiraj.oops.polymorphism.overloading;

public class OverloadingMainDemo {
	public static void main(String[] args) {
		System.out.println("String[]-args");
	}

	public static void main(String args) {
		System.out.println("String-args");
	}

	public static void main() {
		System.out.println("no-args");
	}
}
