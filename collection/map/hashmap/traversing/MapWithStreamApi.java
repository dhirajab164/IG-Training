package com.dhiraj.collection.map.hashmap.traversing;

import java.util.HashMap;

public class MapWithStreamApi {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(11, "Jack");
		map.put(12, "Jill");
		map.put(13, "Jane");
		map.put(14, "Jim");

		map.entrySet().stream().forEach(System.out::println);

		map.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " | " + e.getValue()));

		// iterating values
		map.values().stream().forEach(System.out::println);

		// iterating keys
		map.keySet().stream().forEach(System.out::println);

	}
}
