package com.dhiraj.collection.list.array_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ##ArrayList: 
 * 		# Allows Duplicates
 * 		# Maintains Insertion order
 * 		# Allows null insertion
 * 		# Allows random access
 * 		# Manipulation is slower
 **/

public class ArrayListDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		System.out.println(list.add("asdf")); // true
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("r");
		list.add(""); // empty
		list.add("f");
		list.add("f");// duplicate
		list.add(null);// null

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}
}
