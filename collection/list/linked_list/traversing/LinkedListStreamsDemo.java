package com.dhiraj.collection.list.linked_list.traversing;

import java.util.LinkedList;

public class LinkedListStreamsDemo {
	public static void main(String[] args) {
		LinkedList<String> list = LinkedListSeeder.getList();
		list.stream().forEach(System.out::println);
	}
}
