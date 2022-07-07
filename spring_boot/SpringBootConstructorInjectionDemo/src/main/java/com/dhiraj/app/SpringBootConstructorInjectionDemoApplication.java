package com.dhiraj.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootConstructorInjectionDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootConstructorInjectionDemoApplication.class, args);
		Car car = context.getBean("car", Car.class);
		car.drive();
	}

}
