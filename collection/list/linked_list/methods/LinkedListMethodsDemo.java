package com.dhiraj.collection.list.linked_list.methods;

import java.util.LinkedList;

public class LinkedListMethodsDemo {
	public static void main(String[] args) {
		LinkedList<String> list = getList();

		LinkedList<String> ll = new LinkedList<>();
		ll.add("Jim");
		ll.add("Jill");
		ll.add("Jorge");
		ll.add("Jackson");
		ll.add("Johnson");

		// add(index,e)
		ll.add(1, "Second");
		print("ll.add(1,\"Second\")", ll);

		// get(index,e)
		print("ll.get(1)", ll.get(1));

		// addFirst
		ll.addFirst("First");
		print("ll.addFirst(\"First\")", ll);

		// getFirst
		print("ll.getFirst()", ll.getFirst());

		// addLast
		ll.addLast("Last");
		print("ll.addLast(\"Last\")", ll);

		// getLast
		print("ll.getLast()", ll.getLast());

		// offer
		ll.offer("Offer");
		print("After ll.offer(\"Offer\")", ll);

		// offerFirst
		ll.offerFirst("OfferFirst");
		print("After ll.offerFirst(\"OfferFirst\")", ll);

		// offerLast
		ll.offerLast("OfferLast");
		print("After ll.offerLast(\"OfferLast\")", ll);

		// peek -> retrieves but doesn't remove
		print("ll.peek()", ll.peek());

		// peekFirst
		print("ll.peekFirst()", ll.peekFirst());

		// peekLast
		print("ll.peekLast()", ll.peekLast());

		print("before poll operations", ll);

		// poll -> retrives and removes
		print("ll.poll()", ll.poll());

		// pollFirst
		print("ll.pollFirst()", ll.pollFirst());

		// pollLast
		print("ll.pollLast()", ll.pollLast());

		print("After poll operations", ll);

		// pop
		print("ll.pop()", ll.pop());
		print("After pop operations", ll);

		// push
		ll.push("Jim");
		print("After ll.push(\"Jim\") operations", ll);

		// size
		print("list.size() ", list.size());

		// set
		list.set(2, "Jerry");
		print("after list.set(2, \"Jerry\")", list);

		// sublist
		print("list.subList(2, 4).toString(): ", list.subList(2, 4).toString());

		// addAll
		list.addAll(ll);
		print("Printing List after list.addAll(lst)", list);

		// clone
		LinkedList<String> list1 = (LinkedList<String>) list.clone();
		print("clone of list", list1);

		// retainAll
		System.out.println("......................................................");
		System.out.println("before list1.retainAll(lst)\n" + list1);

		System.out.println("ll:\n" + ll);
		System.out.println("list1.retainAll(lst): " + list1.retainAll(ll)); // true

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
		// print("list.get(12)", list.get(12)); //RE: java.lang.IndexOutOfBoundsException

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

	private static LinkedList<String> getList() {
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("John");
		ll.add("Jane");
		ll.add("Jack");
		ll.add("James");

		return ll;
	}
}
