package com.dhiraj.stream.list.employee;

import java.util.Comparator;
import java.util.stream.Collectors;

public class EmployeeYoungestMaleInProductDevelopmentDepartment {
	public static void main(String[] args) {
		String dept = "Product Development";
		getYoungestEmployeeByDepartment(dept);
	}

	private static void getYoungestEmployeeByDepartment(String dept) {
		Employee employee = Seeder.getEmployees().stream()
				.filter(e -> e.getGender().equals("Male") && e.getDepartment().equals(dept))
				.collect(Collectors.maxBy(Comparator.naturalOrder())).get();		
		System.out.println(employee);
	}
}
