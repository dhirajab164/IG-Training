package com.dhiraj.stream.list.integers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindEvenNumbersFromListDemo {

	public static void main(String[] args) {
		findEven(Seeder.getIntegers());
	}

	static void findEven(List<Integer> list) {
		// approach #1: collecting to list
		List<Integer> evenList = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("Even Numbers List: " + evenList);

		// approach #2: collecting unique using distinct()
		List<Integer> evenList1 = list.stream().filter(n -> n % 2 == 0).distinct().collect(Collectors.toList());
		System.out.println("Distinct Even Numbers List: " + evenList1);

		// approach #3: collecting unique using set
		Set<Integer> evenSet = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toSet());
		System.out.println("Even Numbers No Duplicates: " + evenSet);

		// approach #4: peeking into stream while filtering
		long count = list.stream().filter(n -> n % 2 == 0).peek(System.out::println).count();
		System.out.println("Total count: " + count);
	}

}
