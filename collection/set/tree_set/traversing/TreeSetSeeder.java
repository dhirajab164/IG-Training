package com.dhiraj.collection.set.tree_set.traversing;

import java.util.TreeSet;

public class TreeSetSeeder {

	public static TreeSet<String> getSet() {
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("A");
		ts.add("B");
		ts.add("C");
		ts.add("D");
		ts.add("E"); // true
		ts.add("E");
		return ts;
	}
}
