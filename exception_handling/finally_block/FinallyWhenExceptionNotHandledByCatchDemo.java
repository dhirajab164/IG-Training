package com.dhiraj.exception_handling.finally_block;

public class FinallyWhenExceptionNotHandledByCatchDemo {

	public static void main(String args[]) {
		try {
			int data = 25 / 0; // java.lang.ArithmeticException: / by zero -> not handled
			System.out.println(data);
		} catch (NullPointerException e) {
			System.out.println(e);
		} finally {
			System.out.println("Finally block always executes.");
		}
		System.out.println("rest of the code...");
	}
}
