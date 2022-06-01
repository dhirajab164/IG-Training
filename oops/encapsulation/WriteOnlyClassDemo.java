package com.dhiraj.oops.encapsulation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LoggerClass {
	private String msg;

	public void info(String msg) {
		System.out
				.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + " : " + msg);
	}
}

public class WriteOnlyClassDemo {
	public static void main(String[] args) {
		LoggerClass logger = new LoggerClass();

		logger.info("Execution Begins");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("Execution End");

	}

}
