package com.dhiraj.collection.list.array_list.traversing.iterator;

import java.util.Iterator;
import java.util.List;

import com.dhiraj.collection.list.array_list.traversing.ArrayListSeeder;

public class ArrayListIteratorDemo {
	public static void main(String[] args) {
		List<String> list = ArrayListSeeder.getList();
		Iterator itr = list.iterator();
		
		while (itr.hasNext()) {
			System.out.println(itr.next());			

		}
	}
}
