package com.dhiraj.stream.list.integers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingInAscendingOrderDemo {

	public static void main(String[] args) {
		sortAscending(Seeder.getIntegers());
	}

	static void sortAscending(List<Integer> list) {
		System.out.println("approach #1");
		List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
		System.out.println(collect);

		System.out.println("approach #2");
		List<Integer> collect2 = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		System.out.println(collect2);

		System.out.println("approach #3");
		List<Integer> collect3 = list.stream().sorted((i1, i2) -> Integer.compare(i1, i2)).collect(Collectors.toList());
		System.out.println(collect3);

		System.out.println("approach #4");
		List<Integer> collect4 = list.stream().sorted(Integer::compare).collect(Collectors.toList());
		System.out.println(collect4);
	}

}
