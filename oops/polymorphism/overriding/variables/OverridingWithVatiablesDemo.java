package com.dhiraj.oops.polymorphism.overriding.variables;

class Super {
	int var = 100;
}

class Sub extends Super {
	int var = 200;
}

public class OverridingWithVatiablesDemo {

	public static void main(String[] args) {
		Super superClass = new Super();
		System.out.println(superClass.var); // 100

		Sub sub = new Sub();
		System.out.println(sub.var); // 200

		Super ss = new Sub();
		System.out.println(ss.var); // 100

		/** overriding not available for variables **/
	}

}
