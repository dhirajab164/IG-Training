package com.dhiraj.stream.list.integers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindMaxNumberFromListDemo {
	public static void main(String[] args) {
		findMax(Seeder.getIntegers());
	}

	static void findMax(List<Integer> list) {
		// approach #1
		System.out.println("approach #1");
		list.stream().max(Integer::compare).ifPresent(System.out::println);

		// approach #2 using method reference
		System.out.println("approach #2");
		list.stream().max((i1, i2) -> Integer.compare(i1, i2)).ifPresent(System.out::println);

		// approach #3
		System.out.println("approach #3");
		list.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);

		// approach #4 using Collectors.maxBy
		System.out.println("approach #4");
		list.stream().collect(Collectors.maxBy(Integer::compare)).ifPresent(System.out::println);

		// approach #5
		System.out.println("approach #5");
		list.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).ifPresent(System.out::println);
	}
}
