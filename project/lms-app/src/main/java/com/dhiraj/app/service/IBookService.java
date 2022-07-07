package com.dhiraj.app.service;

import java.util.List;
import java.util.Optional;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.entity.enums.TransactionStatus;

public interface IBookService {

	public Book createBook(Optional<Book> book);

	public Book getBookById(long id);

	public List<Book> getAllBooks();

	public List<Book> getAllBooksByTitle(String name);

	public List<Book> getAllBooksByActive(int active);

	public List<Book> getAllBooksByAuthor(String author);

	public List<Book> getAllBooksByPublication(String publication);

	public Book updateBook(long id, Optional<Book> book);

	public void deleteBookByid(long id);
}
