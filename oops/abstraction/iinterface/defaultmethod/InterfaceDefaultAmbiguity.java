package com.dhiraj.oops.abstraction.iinterface.defaultmethod;

interface Square {
	default void area() {
		System.out.println("Calculating area of square");
	}
}

interface Rectangle {
	default void area() {
		System.out.println("Calculating area of rectangle");
	}
}

class ShapeAreaCalculator implements Square, Rectangle {

	@Override
	public void area() {
		// System.out.println("Calculating default shape area");
		// Rectangle.super.area();
		Square.super.area();
	}
}

public class InterfaceDefaultAmbiguity extends ShapeAreaCalculator {
	public static void main(String[] args) {
		new InterfaceDefaultAmbiguity().area();
	}
}
