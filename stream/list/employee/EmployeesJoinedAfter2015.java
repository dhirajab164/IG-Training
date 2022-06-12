package com.dhiraj.stream.list.employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeesJoinedAfter2015 {
	public static void main(String[] args) {
		List<Employee> collect = Seeder.getEmployees().stream().filter(e -> e.getJoiningYear() > 2015)
				.collect(Collectors.toList());
		collect.stream().forEach(System.out::println);

	}
}
