package com.dhiraj.oops.abstraction.abstract_class;

abstract class AbstractClass {
	void m1() {
	}

	void m2() {
	}
}

abstract class Bank {

	int fdRate;

	Bank() {
		System.out.println("Bank Created.");
		this.fdRate = 5;
	}

	Bank(String msg) {
		System.out.println(msg);
	}

	// abstract int i;
	/** Compile time error, field can not be abstract **/

	// abstract AbstractClass(){}
	/** Compile time error, constructor can not be abstract **/

	abstract int getRateOfInterest();

	final int getFdInterestRate() {
		return 6;
	}

	int getAtmTransactionLimit() {
		return 5;
	}

	// private abstract void abstractMethod();
	/** -->CE: abstract method cannot be private **/

	// static abstract void abstractMethod();
	/** CE: abstract method cannot be static **/
}

abstract class SomeBank extends Bank {
	/** class must implement all abstract methods else declared as abstract **/
}

class Sbi extends Bank {

	Sbi() {
		super("SBI Created.");
	}

	@Override
	int getRateOfInterest() {
		return 5;
	}
}

class Icici extends Bank {

	@Override
	int getRateOfInterest() {
		return 4;
	}

	@Override
	int getAtmTransactionLimit() {
		return 4;
	}

}

public class AbstractClassDemo {
	public static void main(String[] args) {
		Bank sbi = new Sbi();
		System.out.println("SBI Interest Rate: " + sbi.getRateOfInterest());
		System.out.println("SBI FD Rate: " + sbi.getFdInterestRate());
		System.out.println("SBI ATM Transaction Limit: " + sbi.getAtmTransactionLimit());

		System.out.println("----------------------------------------------------");

		Bank icici = new Icici();
		System.out.println("ICICI Interest Rate: " + icici.getRateOfInterest());
		System.out.println("ICICI FD Rate: " + icici.getFdInterestRate());
		System.out.println("ICICI ATM Transaction Limit: " + icici.getAtmTransactionLimit());

		/*
		 * Cannot instantiate the type AbstractClass
		 */
		// AbstractClass ac = new AbstractClass();

	}
}
