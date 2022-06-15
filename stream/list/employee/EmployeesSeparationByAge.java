package com.dhiraj.stream.list.employee;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeesSeparationByAge {
	public static void main(String[] args) {
		Predicate<Employee> checkAge = e -> e.getAge() >= 25;
		Predicate<Employee> checkSalary = e -> e.getSalary() >= 25000;

		partitionEmployeesByCriteria(checkAge);
	}

	private static void partitionEmployeesByCriteria(Predicate<Employee> checkAge) {
		Map<Boolean, List<Employee>> collect = Seeder.getEmployees().stream()
				.collect(Collectors.partitioningBy(checkAge));
		collect.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "=" + e.getValue()));
	}
}
