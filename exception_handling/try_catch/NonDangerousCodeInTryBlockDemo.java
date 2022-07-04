package com.dhiraj.exception_handling.try_catch;

public class NonDangerousCodeInTryBlockDemo {
	public static void main(String[] args) {
		try {
			int data = 10 / 0;
			/** if exception occurs rest of the code won't execute **/
			System.out.println("rest of the code");
		} catch (ArithmeticException e) {
			System.out.println(e);
		}

	}
}
