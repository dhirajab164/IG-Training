package com.dhiraj.stream.list.employee;

import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeAverageAgeGenderWise {
	public static void main(String[] args) {
		Map<String, Double> averageAge = Seeder.getEmployees().stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));

		System.out.println("EmployeeAverageAgeGenderWise: ");
		averageAge.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

	}
}
