package com.dhiraj.design_patterns.factory.shape;

public class ShapeFactory {
	public static IShape getShape(ShapeType type) {
		switch (type) {
		case Circle:
			return new Circle();
		case Square:
			return new Square();
		case Random:
			return new Random();
		default:
			return null;

		}
	}
}
