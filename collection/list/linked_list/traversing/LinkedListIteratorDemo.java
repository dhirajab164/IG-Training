package com.dhiraj.collection.list.linked_list.traversing;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListIteratorDemo {
	public static void main(String[] args) {
		LinkedList<String> list = LinkedListSeeder.getList();

		Iterator<String> llitr = list.iterator();
		while (llitr.hasNext()) {
			System.out.println(llitr.next());
		}

	}
}
