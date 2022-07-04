package com.dhiraj.exception_handling.try_catch;

public class CatchingParentExceptionDemo {
	public static void main(String[] args) {
		try {
			int data = 10 / 0;
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("rest of the code");
	}
}
