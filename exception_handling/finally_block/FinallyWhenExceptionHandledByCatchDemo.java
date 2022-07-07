package com.dhiraj.exception_handling.finally_block;

public class FinallyWhenExceptionHandledByCatchDemo {
	public static void main(String args[]) {
		try {
			int data = 25 / 0;
			System.out.println(data);
		} catch (ArithmeticException e) {
			System.out.println("Exception handled");
			System.out.println(e);
		} finally {
			System.out.println("Finally block always executes.");
		}

		System.out.println("rest of the code...");
	}
}
