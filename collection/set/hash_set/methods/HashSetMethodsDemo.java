package com.dhiraj.collection.set.hash_set.methods;

import java.util.HashSet;

public class HashSetMethodsDemo {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<>();
		hs.add("One");
		hs.add("Two");
		hs.add("Three");
		hs.add("Four");
		hs.add("Five");

		System.out.println(hs.contains("Two"));
		System.out.println("hs.isEmpty(): " + hs.isEmpty());
		System.out.println("hs.size(): " + hs.size());

		if (!hs.contains("Six"))
			hs.add("Six");
		System.out.println("------------------");

		if (!hs.contains("Five"))
			hs.remove("Five");
		System.out.println("------------------");

		System.out.println("forEach()");
		hs.forEach(System.out::println);

		System.out.println();

		System.out.println("stream().forEach()");
		hs.stream().forEach(System.out::println);
	}
}
