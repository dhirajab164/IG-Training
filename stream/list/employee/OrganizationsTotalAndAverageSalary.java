package com.dhiraj.stream.list.employee;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

public class OrganizationsTotalAndAverageSalary {
	public static void main(String[] args) {
		DoubleSummaryStatistics collect = Seeder.getEmployees().stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("OrganizationsTotalSalary: " + collect.getSum());
		System.out.println("OrganizationsAverageSalary: " + collect.getAverage());
		System.out.println("OrganizationsMinSalary: " + collect.getMin());
		System.out.println("OrganizationsMaxSalary: " + collect.getMax());

	}
}
