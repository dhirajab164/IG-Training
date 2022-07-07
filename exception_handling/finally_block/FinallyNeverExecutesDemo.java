package com.dhiraj.exception_handling.finally_block;

public class FinallyNeverExecutesDemo {
	public static void main(String args[]) {
		try {
			System.out.println("try block");
			System.exit(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("Finally does not executes in this case.");
		}
	}
}
