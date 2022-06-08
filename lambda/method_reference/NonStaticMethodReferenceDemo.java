package com.dhiraj.lambda.method_reference;

public class NonStaticMethodReferenceDemo {
	// available method implementation for draw method of Drawable functional interface
	public void drawCircle() {
		System.out.println("Drawing Circle..");
	}

	public static void main(String[] args) {
		Drawable circle = new NonStaticMethodReferenceDemo()::drawCircle;
		circle.draw();
	}
}
