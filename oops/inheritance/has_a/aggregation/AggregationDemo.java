package com.dhiraj.oops.inheritance.has_a.aggregation;

import java.util.ArrayList;
import java.util.List;

class Book {
	private String name;

	public Book(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + "]";
	}

}

class Library {

	List<Book> books = new ArrayList<>();

	public Library(List<Book> books) {
		super();
		this.books = books;
	}

	@Override
	public String toString() {
		return "Library [books=" + books + "]";
	}

	public List<Book> getBooks() {
		return books;
	}

}

public class AggregationDemo {

	public static void main(String[] args) {

		List<Book> books = new ArrayList<>();

		Book b1 = new Book("B1");
		Book b2 = new Book("B2");
		Book b3 = new Book("B3");

		books.add(b1);
		books.add(b2);
		books.add(b3);

		Library library = new Library(books);
		System.out.println(library);

	}

}
