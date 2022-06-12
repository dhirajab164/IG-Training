package com.dhiraj.stream.list.employee;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeAverageSalaryDepartmentWise {
	public static void main(String[] args) {
		System.out.println("EmployeeAverageSalaryDepartmentWise: ");
		Map<String, Double> collect = Seeder.getEmployees().stream().collect(Collectors.groupingBy(
				Employee::getDepartment, LinkedHashMap::new, Collectors.averagingDouble(Employee::getSalary)));
		collect.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));
	}
}
