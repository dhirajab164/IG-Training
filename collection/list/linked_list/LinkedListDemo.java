package com.dhiraj.collection.list.linked_list;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * LinkedList
 * 		# Allows duplicates
 * 		# Maintains insertion order
 * 		# Allows NULL insertion
 * 		# Manipulation is faster than ArrayList 		
 * 
 * **/
public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("John");
		ll.add("Jane");
		ll.add("Jack");
		ll.add("James");
		ll.add("James");
		ll.add(null);
		
		Iterator<String> itr = ll.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
