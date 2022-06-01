package com.dhiraj.oops.polymorphism.overloading;

class Animal {
}

class Monkey extends Animal {
}

class ThisClass {

	public static void thisMethod(int i) {
		System.out.println("int-arg method");
	}

	public static void thisMethod(int... i) {
		System.out.println("var-arg method");
	}

	public static void thisMethod(float f) {
		System.out.println("float-arg method");
	}

	public static void thisMethod(int i, float f) {
		System.out.println("int-float-arg method");
	}

	public static void thisMethod(float f, int i) {
		System.out.println("float-int-arg method");
	}

	public static void thisMethod(String s) {
		System.out.println("String-arg method");
	}

	public static void thisMethod(StringBuffer sb) {
		System.out.println("StringBuffer-arg method");
	}

	public static void thisMethod(Object o) {
		System.out.println("Object-arg method");
	}

	public static void thisMethod(Animal a) {
		System.out.println("Animal-arg method");
	}

	public static void thisMethod(Monkey m) {
		System.out.println("Monkey-arg method");
	}

}

class OverloadingDemo {
	public static void main(String[] args) {
		ThisClass.thisMethod(10);
		ThisClass.thisMethod(); // var-arg
		ThisClass.thisMethod(10, 10, 10); // var-arg

		ThisClass.thisMethod('a');
		ThisClass.thisMethod(10f);
		ThisClass.thisMethod(10, 10f);
		ThisClass.thisMethod(10f, 10);

		// ThisClass.thisMethod(10,10); CE: The method thisMethod(int, float) is
		// ambiguous for the type ThisClass

		// ThisClass.thisMethod(10.5); CE
		ThisClass.thisMethod("hello");
		ThisClass.thisMethod(new StringBuffer("world"));
		ThisClass.thisMethod(new Object());
		// ThisClass.thisMethod(null); //OP:String-arg method ---child class gets
		// priority

		Animal a = new Animal();
		ThisClass.thisMethod(a);

		Monkey m = new Monkey();
		ThisClass.thisMethod(m);

		Animal am = new Monkey();
		ThisClass.thisMethod(am);

	}
}
