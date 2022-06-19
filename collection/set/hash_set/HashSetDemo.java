package com.dhiraj.collection.set.hash_set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSet
 * 		# Allows only unique elements
 * 		# Insertion is based on hashCode
 * 		# Allows 1 NULL
 * 		# Best for search operations
 **/
public class HashSetDemo {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		set.add("One");
		set.add("Two");
		set.add("Three");
		set.add("Four");
		set.add("Five");
		System.out.println("set.add(\"Five\")" + set.add("Five"));
		System.out.println("set.add(\"Six\")" + set.add("Six"));
		set.add(null);		

		System.out.println("-----------------------------------------");
		Iterator<String> i = set.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
