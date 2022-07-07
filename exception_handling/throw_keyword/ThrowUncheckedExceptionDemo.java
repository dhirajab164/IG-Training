package com.dhiraj.exception_handling.throw_keyword;

/** Unchecked exceptions need not be caught using catch or declared explicitly as throws **/
public class ThrowUncheckedExceptionDemo {

	public static void main(String args[]) {
		validateAge(13);
		System.out.println("Rest of the code.");
	}

	public static void validateAge(int age) {
		if (age < 18) {
			throw new ArithmeticException("Person cannot vote.");
		} else {
			System.out.println("Person can vote.");
		}
	}
}
