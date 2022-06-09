package com.dhiraj.stream.list.employee;

import java.util.Map;
import java.util.stream.Collectors;

public class EmpoyeeCountGenderWise {
	public static void main(String[] args) {
		Map<String, Long> collect = Seeder.getEmployees().stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("EmpoyeeCountGenderWise: ");
		collect.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));
	}
}
