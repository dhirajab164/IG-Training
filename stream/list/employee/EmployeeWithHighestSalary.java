package com.dhiraj.stream.list.employee;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeWithHighestSalary {
	public static void main(String[] args) {
		// using max
		Optional<Employee> max = Seeder.getEmployees().stream().max(Comparator.comparingDouble(Employee::getSalary));
		System.out.println("EmployeeWithHighestSalary: " + max.get());

		// using Collectors.maxBy
		System.out.println();
		Optional<Employee> collect = Seeder.getEmployees().stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println(collect.get());

		System.out.println();
		// using custom comparator for employee salary
		// Optional<Employee> findFirst = Seeder.getEmployees().stream().sorted((e1, e2)-> e1.compareTo(e2)).findFirst();
		Optional<Employee> findFirst = Seeder.getEmployees().stream().sorted(Employee::compareTo).findFirst();
		System.out.println(findFirst);

	}

}
