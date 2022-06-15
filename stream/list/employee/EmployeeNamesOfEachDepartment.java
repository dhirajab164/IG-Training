package com.dhiraj.stream.list.employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeNamesOfEachDepartment {
	public static void main(String[] args) {

		System.out.println("EmployeeNamesOfEachDepartment: ");
		Map<String, List<String>> collect = Seeder.getEmployees().stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
		collect.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

	}
}
