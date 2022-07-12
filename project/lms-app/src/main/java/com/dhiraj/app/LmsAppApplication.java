package com.dhiraj.app;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LmsAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LmsAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Application started on {}.", LocalDate.now());
		System.out.println("Application started on." + LocalDate.now());
	}

}
