package com.dhiraj.design_patterns.factory.shape;

public class ShapeFactoryDemo {
	public static void main(String[] args) {
		IShape circle = ShapeFactory.getShape(ShapeType.Circle);
		circle.draw();

		IShape square = ShapeFactory.getShape(ShapeType.Square);
		square.draw();

		IShape random = ShapeFactory.getShape(ShapeType.Random);
		random.draw();
		


	}
}
