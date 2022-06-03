package com.dhiraj.oops.polymorphism.overriding.final_method;

class Super {

	/** cannot override **/
	public final void m1() {
		System.out.println("Super::final m1()");
	}

	/** can be override as final or non-final **/
	public void m2() {
		System.out.println("Super:: m2()");
	}

	public void m3() {
		System.out.println("Super:: m3()");
	}

}

class Sub extends Super {

	/** overriding non-final as final **/
	@Override
	public final void m2() {
		super.m2();
	}

	/** overriding non-final as non-final **/
	@Override
	public final void m3() {
		super.m3();
	}

}

public class OverrdingFinalMethodDemo {
	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.m1();
		sub.m2();
		sub.m3();

	}
}
