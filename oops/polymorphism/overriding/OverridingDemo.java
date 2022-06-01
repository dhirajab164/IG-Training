package com.dhiraj.oops.polymorphism.overriding;

class Vehicle {

	void run() {
		System.out.println("Vehicle is Running.");
	}
}

class Bmw extends Vehicle {

}

class Audi extends Vehicle {

	@Override
	void run() {
		System.out.println("Audi is Running.");
	}
}

public class OverridingDemo {

	public static void main(String[] args) {
		Bmw bmw = new Bmw();
		bmw.run(); // executing parent class method

		Audi audi = new Audi();
		audi.run(); // executing child class method
	}
}
