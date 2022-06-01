package com.dhiraj.oops.polymorphism.overriding;

class Bank {

	void getInterestRate() {
		System.out.println("Bank Interest Rate: " + 5);

	}
}

class Sbi extends Bank {
	@Override
	void getInterestRate() {
		System.out.println("SBI Interest Rate: " + 6);
	}
}

public class RuntimePolymorphism {
	public static void main(String[] args) {

		Bank bank = new Bank();
		bank.getInterestRate();

		Sbi sbi = new Sbi();
		sbi.getInterestRate();

		Bank sbiBank = new Sbi(); // dynamic binding
		sbiBank.getInterestRate();

	}
}
