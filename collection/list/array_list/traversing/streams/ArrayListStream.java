package com.dhiraj.collection.list.array_list.traversing.streams;

import com.dhiraj.collection.list.array_list.traversing.ArrayListSeeder;

public class ArrayListStream {
	public static void main(String[] args) {
		ArrayListSeeder.getList().stream().forEach(System.out::println);
	}
}
