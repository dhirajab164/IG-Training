package com.dhiraj.collection.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * HashMap
 * 		# Values based on hashCode of key
 * 		# Unique keys
 * 		# one Null key, multiple Null values
 * 		# Maintains no order
 * **/
public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(11, "Jack");
		map.put(12, "Jill");
		map.put(13, "Jane");
		map.put(14, "Jim");

		Set<Entry<Integer, String>> entrySet = map.entrySet();
		print("entrySet", entrySet);

		Iterator<Entry<Integer, String>> itr = entrySet.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	private static void print(String msg, Object obj) {
		System.out.println(msg + ": " + obj);
	}
}
