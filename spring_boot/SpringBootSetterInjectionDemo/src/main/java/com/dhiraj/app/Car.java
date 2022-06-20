
package com.dhiraj.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	private long id;
	private String name;

	IEngine engine;

	public Car() {
		super();
	}

	public Car(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void drive() {
		engine.run();
	}

	@Autowired
	public void setEngine(IEngine engine) {
		this.engine = engine;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + "]";
	}

}
