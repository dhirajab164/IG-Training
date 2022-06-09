package com.dhiraj.stream.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapDemo {

	// consumer printing map
	public static void printMap(Map<String, Integer> map) {
		Consumer<Map<String, Integer>> print = m -> m.forEach((k, v) -> System.out.println(k + " | " + v));
		print.accept(map);
	}

	// consumer printing list
	public static void printList(List<Entry<String, Integer>> list) {
		Consumer<List<Entry<String, Integer>>> print = l -> l.stream().forEach(System.out::println);
		print.accept(list);
	}

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("John", 1000);
		map.put("Jane", 2000);
		map.put("Jack", 3000);
		map.put("Jill", 4000);
		map.put("James", 5000);
		map.put("Jones", 4000);

		map.putIfAbsent("James", 2000);
		map.putIfAbsent("Jess", 6000);

		System.out.println(".....................................................................................");

		Stream<Map.Entry<String, Integer>> entrySet = map.entrySet().stream();
		Stream<Integer> values = map.values().stream();
		Stream<String> keys = map.keySet().stream();

		// map.forEach((k,v)-> System.out.println(k+" "+v));

		System.out.println("Employee salary");
		map.forEach((k, v) -> System.out.println(k + "|" + v));
		System.out.println(".....................................................................................");

		// groupingBy salary
		System.out.println("groupingBy salary");
		Map<Integer, List<Entry<String, Integer>>> smap = map.entrySet().stream()
				.collect(Collectors.groupingBy(Entry::getValue));
		smap.entrySet().stream().forEach(System.out::println);
		System.out.println(".....................................................................................");

		// partitioningBy salary>=3000
		System.out.println("partitioningBy salary>=3000");
		Map<Boolean, List<Entry<String, Integer>>> salGt5k = map.entrySet().stream()
				.collect(Collectors.partitioningBy(e -> e.getValue() >= 3000));
		salGt5k.entrySet().stream().forEach(System.out::println);

		// salary>2000
		System.out.println("salary>2000: ");
		List<Map.Entry<String, Integer>> greaterThan2K = map.entrySet().stream().filter(e -> e.getValue() > 2000)
				.collect(Collectors.toList());
		greaterThan2K.forEach(System.out::println);
		System.out.println("..........................................");

		// print "Jacks" salary
		System.out.println("print \"Jacks\" salary: ");
		Optional<Entry<String, Integer>> val = map.entrySet().stream().filter(e -> e.getKey().equals("Jack"))
				.findFirst();
		Integer sal = map.entrySet().stream().filter(e -> e.getKey().equals("Jack")).map(m -> m.getValue()).findFirst()
				.get();
		System.out.println(val.get());
		System.out.println(sal);
		System.out.println("..........................................");

		// sort by keys -> natural sorting/ascending ->List
		System.out.println("sort by keys -> natural sorting/ascending ->list");
		List<Entry<String, Integer>> ascList = map.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.naturalOrder())).collect(Collectors.toList());
		printList(ascList);
		System.out.println("..........................................");

		// sort by keys -> decending->List
		System.out.println("sort by keys -> decending -> list");
		List<Entry<String, Integer>> descList = map.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toList());
		printList(descList);
		System.out.println("..........................................");

		// sort by values ->ascending ->list
		System.out.println("sort by values -> ascending -> list");
		List<Entry<String, Integer>> ascValuesList = map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).collect(Collectors.toList());
		printList(ascValuesList);
		System.out.println("..........................................");

		// sort by values ->descending->List
		System.out.println("sort by values ->descending");
		List<Entry<String, Integer>> dscValuesList = map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
		printList(dscValuesList);
		System.out.println("..........................................");

		// sort values->ascending to LinkedHashMap
		System.out.println("ascending to LinkedHashMap");
		Map<String, Integer> ascMap = map.entrySet().stream().sorted(Entry.comparingByValue(Comparator.naturalOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (o, n) -> n, LinkedHashMap::new));
		printMap(ascMap);
		System.out.println("..........................................");

		// sort values->descending to LinkedHashMap
		System.out.println("descending to LinkedHashMap");
		Map<String, Integer> descMap = map.entrySet().stream().sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (o, n) -> n, LinkedHashMap::new));
		printMap(descMap);
		System.out.println("..........................................");

		// persons with salary=4000
		System.out.println("persons with salary=4000");
		List<Entry<String, Integer>> salaryEquals4KList = map.entrySet().stream().filter(e -> e.getValue() == 4000)
				.collect(Collectors.toList());
		printList(salaryEquals4KList);
		System.out.println("..........................................");
		// Optional

		// sum(salary)

		// summerizing salaries

		// count, sum, avarage, max, min using Collectors.summarizingInt/Double/Long
		IntSummaryStatistics iSummery = map.values().stream().collect(Collectors.summarizingInt(n -> n));
		long count = map.entrySet().stream().collect(Collectors.summarizingInt(n -> n.getValue())).getCount();
		long sum = map.entrySet().stream().collect(Collectors.summarizingInt(n -> n.getValue())).getSum();
		double avarage = map.entrySet().stream().collect(Collectors.summarizingDouble(n -> n.getValue())).getAverage();
		long max = map.entrySet().stream().collect(Collectors.summarizingInt(n -> n.getValue())).getMax();
		long min = map.entrySet().stream().collect(Collectors.summarizingInt(n -> n.getValue())).getMin();

		System.out.println("iSummery.getAverage(): " + iSummery.getAverage());
		System.out.println("iSummery.getCount(): " + iSummery.getCount());
		System.out.println("iSummery.getMax(): " + iSummery.getMax());
		System.out.println("iSummery.getMin(): " + iSummery.getMin());
		System.out.println("iSummery.getSum(): " + iSummery.getSum());

	}
}
