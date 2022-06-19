package com.dhiraj.collection.set.tree_set.traversing;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDescendingIteratorDemo {
	public static void main(String[] args) {

		TreeSet<String> ts = TreeSetSeeder.getSet();

		Iterator<String> ditr = ts.descendingIterator();

		// prints descending order
		while (ditr.hasNext()) {
			System.out.print(ditr.next() + " ");
		}
	}
}
