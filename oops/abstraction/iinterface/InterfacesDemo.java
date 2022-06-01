package com.dhiraj.oops.abstraction.iinterface;

interface IDrawable {
	void drawCircle(int radius);

	default void drawDefaultShape() {
		System.out.println("Drawing Default Shape.");
	}

	static void drawSquare(int side) {
		System.out.println("Drwaing Square with side: " + side);
	}
}

class Shape implements IDrawable {

	@Override
	public void drawCircle(int radius) {
		System.out.println("Drawing Circle with Radius: " + radius);
	}
}

public class InterfacesDemo {
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.drawCircle(4);
		shape.drawDefaultShape();
		IDrawable.drawSquare(5);
	}
}
