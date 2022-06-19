package com.dhiraj.collection.list.linked_list.traversing;

import java.util.List;
import java.util.ListIterator;

public class LinkedListListIteratorDemo {
	public static void main(String[] args) {
		List<String> list = LinkedListSeeder.getList();
		ListIterator<String> litr = list.listIterator();

		while (litr.hasNext()) {
			System.out.println(litr.next());
		}

		System.out.println(".......");
		System.out.println(list.get(litr.previousIndex()));
		System.out.println(".......");

		while (litr.hasPrevious()) {
			System.out.println(litr.previous());
		}

		System.out.println(list);
	}
}
