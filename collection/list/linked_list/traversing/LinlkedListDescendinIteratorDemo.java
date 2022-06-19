package com.dhiraj.collection.list.linked_list.traversing;

import java.util.Iterator;
import java.util.LinkedList;

public class LinlkedListDescendinIteratorDemo {
	public static void main(String[] args) {
		LinkedList<String> list = LinkedListSeeder.getList();

		Iterator<String> ditr = list.descendingIterator();
		while (ditr.hasNext()) {
			System.out.println(ditr.next());
		}
	}
}
