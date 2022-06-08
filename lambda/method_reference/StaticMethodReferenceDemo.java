package com.dhiraj.lambda.method_reference;

public class StaticMethodReferenceDemo {

	// available static method implementation for draw method of Drawable functional interface
	public static void drawSquare() {
		System.out.println("Drawing Square.");
	}

	public static void main(String[] args) {
		Drawable square = StaticMethodReferenceDemo::drawSquare;
		square.draw();
	}
}
