package com.dhiraj.collection.set.tree_set.emlpoyee;

import java.util.TreeSet;

public class EmployeeTreeSetDemo {
	public static void main(String[] args) {

		// sorting based on employee id -> ascending
		TreeSet<Employee> ets = new TreeSet<>();

		Employee e1 = new Employee(111, "John", 1000, 27);
		Employee e2 = new Employee(222, "Jane", 2000, 25);
		Employee e3 = new Employee(333, "Jack", 3000, 24);
		Employee e4 = new Employee(444, "Jim", 4000, 29);

		ets.add(e1);
		ets.add(e2);
		ets.add(e3);
		ets.add(e4);
		ets.forEach(System.out::println);

		System.out.println();

		// sorting based on employee id -> descending
		TreeSet<Employee> etsd = new TreeSet<>(Employee::compareByIdDesc);
		etsd.add(e1);
		etsd.add(e2);
		etsd.add(e3);
		etsd.add(e4);
		etsd.forEach(System.out::println);

	}
}
