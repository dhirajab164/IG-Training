package com.dhiraj.stream.list.integers;

import java.util.List;

public class CountTotalNumbersInListDemo {

	public static void main(String[] args) {
		countTotalNumbers(Seeder.getIntegers());
	}

	static void countTotalNumbers(List<Integer> list) {
		long count = list.stream().count();
		System.out.println(count);
	}

}
