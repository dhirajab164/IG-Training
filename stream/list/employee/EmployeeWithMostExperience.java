package com.dhiraj.stream.list.employee;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeWithMostExperience {

	public static void main(String[] args) {
		System.out.println("EmployeeWithMostExperience");
		Optional<Employee> collect = Seeder.getEmployees().stream()
				.collect(Collectors.minBy(Comparator.comparingInt(Employee::getJoiningYear)));
		System.out.println(collect);

		System.out.println("EmployeeWithMostExperience: approach#2");
		Employee employee = Seeder.getEmployees().stream().sorted(Comparator.comparingInt(Employee::getJoiningYear))
				.findFirst().get();
		System.out.println(employee);

	}

}
