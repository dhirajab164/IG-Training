package com.dhiraj.stream.list.integers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatedNumberFromListDemo {
	public static void main(String[] args) {
		findFirstNonRepeated(Seeder.getIntegers());
	}

	static void findFirstNonRepeated(List<Integer> list) {
		Integer num = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Entry::getKey).findFirst().get();

		System.out.println("First Non repeated number: " + num);
	}
}
