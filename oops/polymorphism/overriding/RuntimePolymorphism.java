package com.dhiraj.oops.polymorphism.overriding;

class Bank {

	void getInterestRate() {
		System.out.println("Bank Interest Rate: " + 5);
	}

	void m1() {
		System.out.println("Bank::m1");
	}
}

class Sbi extends Bank {
	@Override
	void getInterestRate() {
		System.out.println("SBI Interest Rate: " + 6);
	}

	void m2() {
		System.out.println("Sbi::m2");
	}
}

public class RuntimePolymorphism {
	public static void main(String[] args) {

		Bank bank = new Bank();
		bank.getInterestRate();
		bank.m1();

		Sbi sbi = new Sbi();
		sbi.getInterestRate();
		sbi.m1();
		sbi.m2();

		Bank sbiBank = new Sbi(); // dynamic binding
		sbiBank.getInterestRate(); // overridden method
		sbiBank.m1(); // can call only parent class methods

	}
}
