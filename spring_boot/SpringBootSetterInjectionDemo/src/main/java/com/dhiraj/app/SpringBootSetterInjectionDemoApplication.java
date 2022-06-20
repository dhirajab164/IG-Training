package com.dhiraj.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootSetterInjectionDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootSetterInjectionDemoApplication.class, args);
		Car car = context.getBean("car", Car.class);
		IEngine engine = context.getBean("electricEngineService", ElectricEngineService.class);
		car.setEngine(engine);
		car.drive();
	}

}
