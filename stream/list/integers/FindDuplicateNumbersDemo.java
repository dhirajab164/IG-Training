package com.dhiraj.stream.list.integers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateNumbersDemo {

	public static void main(String[] args) {
		findDuplicates(Seeder.getIntegers());
	}

	static void findDuplicates(List<Integer> list) {
		Set<Integer> set = new HashSet<>();
		List<Integer> slist = list.stream().filter(n -> !set.add(n)).collect(Collectors.toList());
		slist.stream().forEach(System.out::println);
	}

}
