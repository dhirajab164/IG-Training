package com.dhiraj.collection.set.tree_set;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetComparatorDemo {
	public static void main(String[] args) {

		// Ascending order
		TreeSet<String> tsa = new TreeSet<String>();
		tsa.add("A");
		tsa.add("B");
		tsa.add("C");
		tsa.add("D");
		tsa.add("E");

		System.out.println("Ascending order: ");
		tsa.forEach(e -> System.out.print(e + " "));

		// Descending order
		TreeSet<String> tsd = new TreeSet<String>((e1, e2) -> e2.compareTo(e1));
		tsd.add("A");
		tsd.add("B");
		tsd.add("C");
		tsd.add("D");
		tsd.add("E");

		System.out.println("\n\nDescendingorder: ");
		tsd.forEach(e -> System.out.print(e + " "));
	}
}
