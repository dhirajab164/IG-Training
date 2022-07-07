package com.dhiraj.exception_handling.finally_block;

public class FinallyWhenNoExceptionDemo {
	public static void main(String args[]) {
		try {
			int data = 25 / 5;
			System.out.println(data);
		} catch (NullPointerException e) {
			System.out.println(e);
		} finally {
			System.out.println("Finally block always executes.");
		}
		System.out.println("rest of phe code...");
	}
}
