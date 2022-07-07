package com.dhiraj.exception_handling.throw_keyword;

import java.io.FileNotFoundException;

/** Checked exceptions must be caught using catch or declared explicitly as throws **/
public class ThrowCheckedExceptionDemo {

	public static void main(String[] args) {
		try {
			checkFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void checkFile() throws FileNotFoundException {
		throw new FileNotFoundException();
	}
}
