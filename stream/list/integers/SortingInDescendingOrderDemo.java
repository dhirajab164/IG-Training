package com.dhiraj.stream.list.integers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingInDescendingOrderDemo {

	public static void main(String[] args) {
		sortDescneding(Seeder.getIntegers());

	}

	static void sortDescneding(List<Integer> list) {
		// approach 1
		System.out.println("approach #1");
		List<Integer> collect = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(collect);

		// approach 2
		System.out.println("approach #2");
		List<Integer> collect2 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(collect2);

		// approach 3
		System.out.println("approach #3");
		List<Integer> collect3 = list.stream().sorted((i1, i2) -> i2.compareTo(i1)).collect(Collectors.toList());
		System.out.println(collect3);

	}

}
