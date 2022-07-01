package com.dhiraj.app;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLoggingDemoApplication {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoggingDemoApplication.class, args);
	}

	@PostConstruct
	public void init() {
		logger.info("init");
		logger.trace("TRACE");
		logger.info("INFO");
		logger.debug("DEBUG");
		logger.error("ERROR");
		logger.warn("WARN");
	}

}
