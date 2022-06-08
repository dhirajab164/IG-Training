package com.dhiraj.lambda.method_reference;

@FunctionalInterface
interface Drawable {
	public void draw();
}

public class StaticMethodReferenceDemo {

	public static void drawSquare() {
		System.out.println("Drawing Square.");
	}

	public static void main(String[] args) {

		Drawable square = StaticMethodReferenceDemo::drawSquare;
		square.draw();
	}
}
