package com.dhiraj.stream.list.integers;

import java.util.List;

public class FindFirstElementDemo {

	public static void main(String[] args) {
		findFirstElement(Seeder.getIntegers());
	}

	static void findFirstElement(List<Integer> list) {
		list.stream().findFirst().ifPresent(System.out::println);

	}

}
