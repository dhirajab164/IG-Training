package com.dhiraj.oops.abstraction.iinterface.defaultmethod;

/** intrface with default methods **/
interface GreetingsInterface {

	default void greetAtMorning() {
		System.out.println("Good Morning");
	}

	default void greetAtEvening() {
		System.out.println("Good Evening");
	}
}

public class InterfaceDefaultMethodsDemo implements GreetingsInterface {
	// overriding default method
	public void greetAtEvening() {
		System.out.println("Hello");
	}

	public static void main(String[] args) {
		new InterfaceDefaultMethodsDemo().greetAtMorning();
		new InterfaceDefaultMethodsDemo().greetAtEvening();
	}
}