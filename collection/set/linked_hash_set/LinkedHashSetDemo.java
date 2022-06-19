package com.dhiraj.collection.set.linked_hash_set;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * LinkedHashSet
 * 		# Contains unique elements
 * 		# Maintains insertion order
 * 		# Allows null
 *   
 * **/
public class LinkedHashSetDemo {
	public static void main(String[] args) {
		LinkedHashSet<String> al = new LinkedHashSet<String>();
		al.add("One");
		al.add("Two");
		al.add("Four");
		al.add("Five");
		al.add("Three");
		al.add(null);
		al.add(null);

		Iterator<String> itr = al.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
