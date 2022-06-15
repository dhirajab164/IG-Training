package com.dhiraj.stream.list.integers;

import java.util.List;
import java.util.stream.Collectors;

public class FindNumbersStartingWith1Demo {

	public static void main(String[] args) {
		startingWith1(Seeder.getIntegers());

	}

	static void startingWith1(List<Integer> list) {

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

}
