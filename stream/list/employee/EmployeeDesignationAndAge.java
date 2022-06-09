package com.dhiraj.stream.list.employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDesignationAndAge {
	public static void main(String[] args) {

		List<Employeee> emps = getEmployees().stream().filter(e -> getByDesignationAndAge(e, "Manager", 30))
				.collect(Collectors.toList());

		emps.stream().forEach(System.out::println);
	}

	private static boolean getByDesignationAndAge(Employeee e, String designation, Integer age) {
		return e.getDesignation().equals("Manager") && e.getAge() > 30;
	}

	public static List<Employeee> getEmployees() {
		return Arrays.asList(new Employeee(101, "John", 28, "Developer"), new Employeee(102, "Jane", 28, "Tester"),
				new Employeee(103, "Jack", 30, "Lead"), new Employeee(104, "Jill", 29, "Developer"),
				new Employeee(105, "James", 32, "Manager"), new Employeee(106, "Jim", 34, "Manager"));
	}
}

class Employeee {
	private long empId;
	private String name;
	private int age;
	private String designation;

	public Employeee() {
		super();
	}

	public Employeee(long empId, String name, int age, String designation) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.designation = designation;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employeee [empId=" + empId + ", name=" + name + ", age=" + age + ", designation=" + designation + "]";
	}

}
