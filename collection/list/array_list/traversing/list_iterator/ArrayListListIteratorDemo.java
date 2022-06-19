package com.dhiraj.collection.list.array_list.traversing.list_iterator;

import java.util.List;
import java.util.ListIterator;

import com.dhiraj.collection.list.array_list.traversing.ArrayListSeeder;

public class ArrayListListIteratorDemo {
	public static void main(String[] args) {
		List<String> list = ArrayListSeeder.getList();
		ListIterator<String> litr = list.listIterator();
		while (litr.hasNext()) {
			System.out.println(litr.next());
		}

		litr.set("Johnnny");

		System.out.println(".......");
		System.out.println(list.get(litr.previousIndex()));

		System.out.println(".......");

		while (litr.hasPrevious()) {
			System.out.println(litr.previous());
		}

		System.out.println(list);

	}
}