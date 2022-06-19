package com.dhiraj.collection.set.tree_set.methods;

import java.util.ArrayList;
import java.util.TreeSet;

public class TreeSetMethodsDemo {
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("A");
		ts.add("B");
		ts.add("C");
		ts.add("D");
		ts.add("E");

		ArrayList<String> al = new ArrayList<String>();
		al.add("F");
		al.add("G");

		// addAll
		ts.addAll(al);

		print("Printing ts ", ts);

		// ceiling
		print("ts.ceiling(\"A\")", ts.ceiling("A"));
		// print("ts.ceiling(null)", ts.ceiling(null)); //RE: NullPointerException

		// contains
		print("ts.contains(\"D\")", ts.contains("D"));

		// descendingSet: reverse order view
		print("ts.descendingSet()", ts.descendingSet());
		print("Printing ts ", ts);

		// first
		print("ts.first()", ts.first());

		// floor
		print("ts.floor(\"B\")", ts.floor("B"));

		// headSet excluding given elem
		print("ts.headset(\"D\")", ts.headSet("D"));

		// headSet including given elem
		print("ts.headset(\"D\", true)", ts.headSet("D", true));

		// higher
		print("ts.higher(\"B\")", ts.higher("B"));

		// last
		print("ts.last()", ts.last());

		// pollFirst: Retrieves and removes the first
		print("ts.pollFirst()", ts.pollFirst());
		print("Printing ts ", ts);

		// pollLast:Retrieves and removes the last
		print("ts.pollLast()", ts.pollLast());
		print("Printing ts ", ts);

		// subSet including start excluding end
		print("ts.subSet(\"B\", \"E\")", ts.subSet("B", "E"));

		// subSet including start excluding end
		print("ts.subSet(\"B\",true \"E\", true)", ts.subSet("B", true, "E", true));

		// tailSet: greater than elem
		print("ts.tailSet(\"D\")", ts.tailSet("D"));

		// tailSet: greater than elem inclusive
		print("ts.tailSet(\"D\", true)", ts.tailSet("D", true));

	}

	private static void print(String string, Object obj) {
		System.out.println(string + ": " + obj);

	}
}
