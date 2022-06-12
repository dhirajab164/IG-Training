package com.dhiraj.stream.list.employee;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeesCountInEachDepartment {
	public static void main(String[] args) {
		System.out.println("EmployeesCountInEachDepartment: ");
		Map<String, Long> collect = Seeder.getEmployees().stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		collect.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

		System.out.println("EmployeesCountInEachDepartment in insertion order: ");
		LinkedHashMap<String, Long> collect2 = Seeder.getEmployees().stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new, Collectors.counting()));
		collect2.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

	}
}
