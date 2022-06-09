package com.dhiraj.stream.map.employees;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationsOnEmployeeMapDemo {

	// consumer printing list
	public static void printList(List<Entry<Integer, Employee>> list) {
		Consumer<List<Entry<Integer, Employee>>> print = l -> l.stream().forEach(System.out::println);
		print.accept(list);
	}

	public static void main(String[] args) {

		Map<Integer, Employee> emps = new HashMap<>();
		emps.put(1, new Employee("John", "Sales", 1000));
		emps.put(2, new Employee("Jane", "Marketing", 2000));
		emps.put(3, new Employee("Jack", "Sales", 3000));
		emps.put(4, new Employee("Jill", "HR", 400));
		emps.put(5, new Employee("James", "Finance", 5000));

		// sort by employee names ascending
		System.out.println("sort by employee names ascending");
		List<Entry<Integer, Employee>> sortedEmpsByNameAsc = emps.entrySet().stream()
				.sorted(Entry.comparingByValue(Comparator.comparing(Employee::getName))).collect(Collectors.toList());
		printList(sortedEmpsByNameAsc);
		System.out.println("..........................................");

		// sort by employee names descending
		System.out.println("sort by employee names descending");

		List<Entry<Integer, Employee>> sortedEmpsByNameDsc = emps.entrySet().stream()
				.sorted(Collections.reverseOrder(Entry.comparingByValue(Comparator.comparing(Employee::getName))))
				.collect(Collectors.toList());
		printList(sortedEmpsByNameDsc);
		System.out.println("..........................................");
	}
}

class Employee {
	String name;
	String dept;
	int salary;

	public Employee(String name, String dept, int salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}

}
