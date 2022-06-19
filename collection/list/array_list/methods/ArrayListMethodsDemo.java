package com.dhiraj.collection.list.array_list.methods;

import java.util.ArrayList;

public class ArrayListMethodsDemo {
	public static void main(String[] args) {

		ArrayList<String> list = getList();
		print("Printing List:", list);

		ArrayList<String> lst = new ArrayList<>();
		lst.add("Jim");
		lst.add("Jill");
		lst.add("Jorge");
		lst.add("Jackson");
		lst.add("Johnson");

		// size
		print("list.size() ", list.size());

		// set
		list.set(2, "Jerry");
		print("after list.set(2, \"Jerry\")", list);

		// sublist
		print("list.subList(2, 4).toString(): ", list.subList(2, 4).toString());

		// addAll
		list.addAll(lst);
		print("Printing List after list.addAll(lst)", list);

		// clone
		ArrayList<String> list1 = (ArrayList<String>) list.clone();
		print("clone of list", list1);

		// retainAll
		System.out.println("......................................................");
		System.out.println("before list1.retainAll(lst)\n" + list1);

		System.out.println("lst:\n" + lst);
		System.out.println("list1.retainAll(lst): " + list1.retainAll(lst)); // true

		System.out.println("after list1.retainAll(lst)\n" + list1);
		System.out.println("......................................................");

		// remove
		list.remove("Jill");
		print("Printing List after list.remove(\"Jill\")", list);

		// removeIf
		list.removeIf(s -> s.equalsIgnoreCase("Jenny"));
		print("list.removeIf(s -> s.equalsIgnoreCase(\"Jenny\"))", list);

		// contains
		print("list.contains(\"John\")", list.contains("John"));
		print("list.contains(\"Jill\")", list.contains("Jill"));

		// get
		print("list.get(2)", list.get(2));
		// print("list.get(12)", list.get(12)); //RE:
		// java.lang.IndexOutOfBoundsException

		// indexOf
		print("list.indexOf(\"James\")", list.indexOf("James"));

		// lastIndexOf()
		print("list.lastIndexOf(\"James\")", list.lastIndexOf("James"));

		// isEmpty()
		print("list.isEmpty()", list.isEmpty());

		// sort ascending
		list.sort((s1, s2) -> s1.compareTo(s2));
		print("after list.sort((s1,s2)->s1.compareTo(s2))", list);

		// sort ascending
		list.sort((s1, s2) -> s2.compareTo(s1));
		print("after list.sort((s1,s2)->s2.compareTo(s1))", list);

		// toArray
		Object[] array = list.toArray();
		System.out.println("array.length: " + array.length);
		for (Object str : array) {
			System.out.println(str);
		}
	}

	private static void print(String msg, Object obj) {
		System.out.println(msg + ":\n" + obj + "\n");
	}

	private static ArrayList<String> getList() {
		ArrayList<String> list = new ArrayList<>();
		list.add("Jack");
		list.add("John");
		list.add("Jane");
		list.add("Jenny");
		list.add("James");
		list.add("James");
		return list;
	}
}
