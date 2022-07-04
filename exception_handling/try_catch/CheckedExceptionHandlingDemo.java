package com.dhiraj.exception_handling.try_catch;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CheckedExceptionHandlingDemo {

	public static void main(String[] args) {
		PrintWriter pw;
		try {
			pw = new PrintWriter("demo.txt");
			pw.println("saved");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		System.out.println("File saved successfully");
	}

}
