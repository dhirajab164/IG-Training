package com.dhiraj.app.service;

import java.util.List;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.entity.enums.Active;

public interface IBookService {

	public Book createBook(Book book);

	public Book getBookById(long id);

	public List<Book> getAllBooks();

	public List<Book> getAllBooksByTitle(String name);

	public List<Book> getAllBooksByActive(Active active);

	public List<Book> getAllBooksByAuthor(String author);

	public List<Book> getAllBooksByPublication(String publication);

	public Book updateBook(long id, Book book);

	public void deleteBookByid(long id);
}
