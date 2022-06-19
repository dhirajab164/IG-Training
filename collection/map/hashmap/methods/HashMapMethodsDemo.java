package com.dhiraj.collection.map.hashmap.methods;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapMethodsDemo {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(11, "Jack");
		map.put(12, "Jill");
		map.put(13, "Jane");
		map.put(14, "Jim");

		print("Printing Map: ", map);

		// put
		print("map.put(11, \"John\")", map.put(11, "John"));
		print("Printing Map: ", map);

		print("map.put(11, \"John\")", map.put(11, "Jack"));
		print("Printing Map: ", map);

		// putIfAbsent
		print("map.putIfAbsent(11, \"Jones\")", map.putIfAbsent(11, "Jones"));
		print("map.putIfAbsent(15, \"Jones\")", map.putIfAbsent(15, "Jones"));
		print("Printing Map: ", map);

		//replace(k,v)
		print("map.replace(14, \"Jimmy\")", map.replace(14, "Jimmy"));
		print("Printing Map: ", map);
		
		//replace(k,ov,nv)
		print("map.replace(14,\"Jimmy\", \"Jim\")",map.replace(14,"Jimmy", "Jim"));
		print("Printing Map: ", map);

		// get
		print("map.get(11)", map.get(11));

		// getOrDefault
		print("map.getOrDefault(11)", map.getOrDefault(11, "Default"));
		print("map.getOrDefault(11)", map.getOrDefault(21, "Default"));

		// containsKey
		print("map.containsKey(11)", map.containsKey(11));
		print("map.containsKey(111)", map.containsKey(111));

		// containsValue
		print("map.containsValue(\"Jack\")", map.containsValue("Jack"));
		print("map.containsValue(\"Jacky\")", map.containsValue("Jacky"));

		// keySet
		Set<Integer> keys = map.keySet();
		print("Keys", keys);

		// values
		Collection<String> values = map.values();
		print("Values", values);

		// entrySet
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		print("entrySet", entrySet);

	}

	private static void print(String msg, Object obj) {
		System.out.println(msg + ": " + obj);
	}
}
