package com.dhiraj.stream.list.employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeesJoinedAfter2015 {
	public static void main(String[] args) {
		System.out.println("Employees Joined after 2015");
		List<Employee> employees = Seeder.getEmployees().stream().filter(e -> e.getJoiningYear() > 2015)
				.collect(Collectors.toList());
		employees.stream().forEach(System.out::println);

		System.out.println("Employee Names Joined after 2015");
		List<String> employeeNames = Seeder.getEmployees().stream().filter(e -> e.getJoiningYear() > 2015)
				.map(Employee::getName).collect(Collectors.toList());
		employeeNames.stream().forEach(System.out::println);

	}
}
