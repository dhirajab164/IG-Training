package com.dhiraj.stream.list.integers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstRepeatedNumberFromListDemo {
	public static void main(String[] args) {
		findFirstRepeated(Seeder.getIntegers());
	}

	static void findFirstRepeated(List<Integer> list) {
		Integer num = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(Entry -> Entry.getValue() > 1).map(Entry::getKey).findFirst().get();
		System.out.println("First Repeated Element:" + num);
	}
}
