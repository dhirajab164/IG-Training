package com.dhiraj.stream.list.integers;

import java.util.Arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamOperationsOnIntegerList {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 15, 32, 98);
		System.out.println("List : " + list);
		System.out.println("---------------------------------------------------------------------");

		// even
		System.out.println("Even Numebrs: ");
		findEven(list);
		System.out.println("---------------------------------------------------------------------");

		// starting with 1
		System.out.println("Numbers starting with 1: ");
		startingWith1(list);
		System.out.println("---------------------------------------------------------------------");

		// duplicates
		System.out.println("Duplicates: ");
		findDuplicates(list);
		System.out.println("---------------------------------------------------------------------");

		// first elem
		System.out.println("First Number: ");
		findFirstElement(list);
		System.out.println("---------------------------------------------------------------------");

		// total elems
		System.out.println("Total Numebrs: ");
		countTotalNumbers(list);
		System.out.println("---------------------------------------------------------------------");

		// max
		System.out.println("Maximum Numebr: ");
		findMax(list);
		System.out.println("---------------------------------------------------------------------");

		// first non-repeated
		System.out.println("first non-repeated Numebrs: ");
		findFirstNonRepeated(list);
		System.out.println("---------------------------------------------------------------------");

		// first repeated
		System.out.println("first repeated Numebrs: ");
		findFirstRepeated(list);
		System.out.println("---------------------------------------------------------------------");

		// sort asc
		System.out.println("Sorted Ascending Numebrs: ");
		sortAscending(list);
		System.out.println("---------------------------------------------------------------------");

		// sort desc
		System.out.println("Sorted Descending Numebrs: ");
		sortDescneding(list);
		System.out.println("---------------------------------------------------------------------");
	}

	private static void sortDescneding(List<Integer> list) {
		System.out.println("approach #1");
		// approach 1
		list.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

		System.out.println("approach #2");
		// approach 2
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		System.out.println("approach #3");
		// approach 3
		list.stream().sorted((i1, i2) -> i2.compareTo(i1)).forEach(System.out::println);
	}

	private static void sortAscending(List<Integer> list) {
		System.out.println("approach #1");
		list.stream().sorted().forEach(System.out::println);
		System.out.println("approach #2");
		list.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		System.out.println("approach #3");
		list.stream().sorted((i1, i2) -> i1.compareTo(i2)).forEach(System.out::println);
	}

	private static void findFirstRepeated(List<Integer> list) {
		list.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(Entry -> Entry.getValue() > 1).map(Entry::getKey).findFirst()
				.ifPresent(System.out::println);
	}

	private static void findFirstNonRepeated(List<Integer> list) {
		Integer num = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Entry::getKey).findFirst().get();
		System.out.println(num);
	}

	private static void findMax(List<Integer> list) {
		// approach #1
		list.stream().max(Integer::compare).ifPresent(System.out::println);
		// list.stream().max((i1, i2) -> Integer.compare(i1,
		// i2)).ifPresent(System.out::println);
		// approach #2
		list.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);
	}

	private static void countTotalNumbers(List<Integer> list) {
		long count = list.stream().count();
		System.out.println(count);
	}

	private static void findFirstElement(List<Integer> list) {
		list.stream().findFirst().ifPresent(System.out::println);

	}

	private static void findDuplicates(List<Integer> list) {
		Set<Integer> set = new HashSet<>();
		List<Integer> slist = list.stream().filter(n -> !set.add(n)).collect(Collectors.toList());
		slist.stream().forEach(System.out::println);
	}

	private static void startingWith1(List<Integer> list) {

		// output in string format : using String.startsWith()
		System.out.println("appraoach #1");
		List<String> slist = list.stream().map(String::valueOf).filter(s -> s.startsWith("1"))
				.collect(Collectors.toList());
		slist.stream().forEach(System.out::println);

		// output in integer format : using String.startsWith()
		System.out.println("approach #2");
		List<Integer> ilist = list.stream().map(String::valueOf).filter(s -> s.startsWith("1")).map(Integer::valueOf)
				.collect(Collectors.toList());
		ilist.stream().forEach(System.out::println);

		// output in string format: using String.charAt()
		System.out.println("approach #3");
		List<String> cslist = list.stream().map(String::valueOf).filter(s -> s.charAt(0) == '1')
				.collect(Collectors.toList());
		cslist.stream().forEach(System.out::println);

		// output in integer format: using String.charAt()
		System.out.println("approach #3");
		List<Integer> cilist = list.stream().map(String::valueOf).filter(s -> s.charAt(0) == '1').map(Integer::valueOf)
				.collect(Collectors.toList());
		cilist.stream().forEach(System.out::println);

	}

	private static void findEven(List<Integer> list) {
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
