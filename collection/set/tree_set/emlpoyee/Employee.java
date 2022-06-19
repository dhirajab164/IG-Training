package com.dhiraj.collection.set.tree_set.emlpoyee;

public class Employee implements Comparable<Employee> {
	private long id;
	private String name;
	private double salary;
	private long age;

	public Employee() {
		super();
	}

	public Employee(long id, String name, double salary, long age) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}

	// comparing based on employee id
	@Override
	public int compareTo(Employee emp) {
		if (this.id > emp.id)
			return 1;
		if (this.id < emp.id)
			return -1;
		else
			return 0;
	}

	public int compareByIdDesc(Employee emp) {
		if (this.id > emp.id)
			return -1;
		if (this.id < emp.id)
			return 1;
		else
			return 0;
	}

}
