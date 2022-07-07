package com.dhiraj.exception_handling.try_catch;

public class ResolvingExceptionInCatchDemo {
	public static void main(String[] args) {
		int i = 50;
		int j = 0;
		int data;
		try {
			data = i / j;
		} catch (Exception e) {
			System.out.println(i / (j + 2));
		}
	}
}
