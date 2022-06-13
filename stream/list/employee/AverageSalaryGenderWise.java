package com.dhiraj.stream.list.employee;

import java.util.Map;
import java.util.stream.Collectors;

public class AverageSalaryGenderWise {
	public static void main(String[] args) {
		Map<String, Double> collect = Seeder.getEmployees().stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		collect.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));
	}
}
