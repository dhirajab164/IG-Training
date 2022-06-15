package com.dhiraj.stream.list.employee;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeOldestInTheOrganization {
	public static void main(String[] args) {

		System.out.println("Oldetst employee in organization: ");

		Optional<Employee> employee = Seeder.getEmployees().stream()
				.collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));
		if (employee.isPresent())
			System.out.println(employee.get().getName() + " | " + employee.get().getAge() + " | "
					+ employee.get().getDepartment());
	}
}
