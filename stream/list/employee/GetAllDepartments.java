package com.dhiraj.stream.list.employee;

import java.util.Set;
import java.util.stream.Collectors;

public class GetAllDepartments {
	public static void main(String[] args) {
		Set<String> departments = Seeder.getEmployees().stream().map(Employee::getDepartment)
				.collect(Collectors.toSet());
		System.out.println("GetAllDepartments: ");
		departments.stream().forEach(System.out::println);
	}
}
