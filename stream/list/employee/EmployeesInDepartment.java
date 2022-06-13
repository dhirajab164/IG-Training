package com.dhiraj.stream.list.employee;

import java.util.Map;
import java.util.stream.Collectors;

public class EmployeesInDepartment {
	public static void main(String[] args) {
		String dept = "Sales And Marketing";
		getCountOfEmployeesInDepartment(dept);
	}

	private static void getCountOfEmployeesInDepartment(String dept) {
		Map<String, Long> collect = Seeder.getEmployees().stream().filter(e -> e.getDepartment() == dept)
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		collect.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

	}
}
