package com.dhiraj.exception_handling.nested_try;

public class NestedTryDemo {

	public static void main(String[] args) {

		try {
			try {
				int b = 39 / 0;
			} catch (ArithmeticException e) {
				System.out.println("catch1: " + e);
			}
			try {
				int a[] = new int[5];
				a[5] = 4;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("catch2: " + e);
			}
			System.out.println("other statement");
		} catch (Exception e) {
			System.out.println("outer catch: " + e);
		}

		System.out.println("rest of the code");
	}
}
