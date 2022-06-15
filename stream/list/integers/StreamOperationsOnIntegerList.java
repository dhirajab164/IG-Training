package com.dhiraj.stream.list.integers;

import java.util.Arrays;
import java.util.List;

public class StreamOperationsOnIntegerList {

	public static void main(String[] args) {
		List<Integer> list = Seeder.getIntegers();
		System.out.println("List : " + list);
		System.out.println("---------------------------------------------------------------------");

		// even
		System.out.println("Even Numebrs: ");
		FindEvenNumbersFromListDemo.findEven(list);
		System.out.println("---------------------------------------------------------------------");

		// starting with 1
		System.out.println("Numbers starting with 1: ");
		FindNumbersStartingWith1Demo.startingWith1(list);
		System.out.println("---------------------------------------------------------------------");

		// duplicates
		System.out.println("Duplicates: ");
		FindDuplicateNumbersDemo.findDuplicates(list);
		System.out.println("---------------------------------------------------------------------");

		// first elem
		System.out.println("First Number: ");
		FindFirstElementDemo.findFirstElement(list);
		System.out.println("---------------------------------------------------------------------");

		// total elems
		System.out.println("Total Numebrs: ");
		CountTotalNumbersInListDemo.countTotalNumbers(list);
		System.out.println("---------------------------------------------------------------------");

		// max
		System.out.println("Maximum Numebr: ");
		FindMaxNumberFromListDemo.findMax(list);
		System.out.println("---------------------------------------------------------------------");

		// first non-repeated
		System.out.println("first non-repeated Numebrs: ");
		FindFirstNonRepeatedNumberFromListDemo.findFirstNonRepeated(list);
		System.out.println("---------------------------------------------------------------------");

		// first repeated
		System.out.println("first repeated Numebrs: ");
		FindFirstRepeatedNumberFromListDemo.findFirstRepeated(list);
		System.out.println("---------------------------------------------------------------------");

		// sort asc
		System.out.println("Sorted Ascending Numebrs: ");
		SortingInAscendingOrderDemo.sortAscending(list);
		System.out.println("---------------------------------------------------------------------");

		// sort desc
		System.out.println("Sorted Descending Numebrs: ");
		SortingInDescendingOrderDemo.sortDescneding(list);
		System.out.println("---------------------------------------------------------------------");
	}

	/**
	 * @deprecated Use
	 *             {@link SortingInDescendingOrderDemo#sortDescneding(List<Integer>)}
	 *             instead
	 */
	private static void sortDescneding(List<Integer> list) {
		SortingInDescendingOrderDemo.sortDescneding(list);
	}

	/**
	 * @deprecated Use
	 *             {@link SortingInAscendingOrderDemo#sortAscending(List<Integer>)}
	 *             instead
	 */
	private static void sortAscending(List<Integer> list) {
		SortingInAscendingOrderDemo.sortAscending(list);
	}

	/**
	 * @deprecated Use
	 *             {@link FindFirstRepeatedNumberFromListDemo#findFirstRepeated(List<Integer>)}
	 *             instead
	 */
	private static void findFirstRepeated(List<Integer> list) {
		FindFirstRepeatedNumberFromListDemo.findFirstRepeated(list);
	}

	/**
	 * @deprecated Use
	 *             {@link FindFirstNonRepeatedNumberFromListDemo#findFirstNonRepeated(List<Integer>)}
	 *             instead
	 */
	private static void findFirstNonRepeated(List<Integer> list) {
		FindFirstNonRepeatedNumberFromListDemo.findFirstNonRepeated(list);
	}

	/**
	 * @deprecated Use {@link FindMaxNumberFromListDemo#findMax(List<Integer>)}
	 *             instead
	 */
	private static void findMax(List<Integer> list) {
		FindMaxNumberFromListDemo.findMax(list);
	}

	/**
	 * @deprecated Use
	 *             {@link CountTotalNumbersInListDemo#countTotalNumbers(List<Integer>)}
	 *             instead
	 */
	private static void countTotalNumbers(List<Integer> list) {
		CountTotalNumbersInListDemo.countTotalNumbers(list);
	}

	/**
	 * @deprecated Use {@link FindFirstElementDemo#findFirstElement(List<Integer>)}
	 *             instead
	 */
	private static void findFirstElement(List<Integer> list) {
		FindFirstElementDemo.findFirstElement(list);
	}

	/**
	 * @deprecated Use
	 *             {@link FindDuplicateNumbersDemo#findDuplicates(List<Integer>)}
	 *             instead
	 */
	private static void findDuplicates(List<Integer> list) {
		FindDuplicateNumbersDemo.findDuplicates(list);
	}

	/**
	 * @deprecated Use {@link FindNumbersStartingWith1#startingWith1(List<Integer>)}
	 *             instead
	 */
	private static void startingWith1(List<Integer> list) {
		FindNumbersStartingWith1Demo.startingWith1(list);
	}

	/**
	 * @deprecated Use {@link FindEvenNumbersFromListDemo#findEven(List<Integer>)}
	 *             instead
	 */
	private static void findEven(List<Integer> list) {
		FindEvenNumbersFromListDemo.findEven(list);
	}

}
