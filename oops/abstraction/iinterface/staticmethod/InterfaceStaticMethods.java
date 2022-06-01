package com.dhiraj.oops.abstraction.iinterface.staticmethod;

interface CarInterface {
	public static void drive() {
		System.out.println("Driving car...");
	}
}

interface BikeInterface {
	public static void drive() {
		System.out.println("Driving Bike...");
	}
}

// no overriding for static methods
public class InterfaceStaticMethods implements CarInterface, BikeInterface {

	public static void main(String[] args) {
		CarInterface.drive();
		BikeInterface.drive();
	}

}
