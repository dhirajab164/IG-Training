package com.dhiraj.collection.set.tree_set;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet
 * 		# 
 * 		# Contains unique elements
 * 		# faster access and retrieval  time
 * 		# No null insertion
 * 		# Maintains ascending order
 * 		#
 * **/
public class TreeSetDemo {

	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("A");
		ts.add("B");
		ts.add("C");
		ts.add("D");
		ts.add("E"); // true
		ts.add("E"); // false : duplicate
		// ts.add(null); //RE: NullPointerException
		
		Iterator<String> itr = ts.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
