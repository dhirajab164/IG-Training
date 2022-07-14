package com.dhiraj.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.exception.BusinessException;
import com.dhiraj.app.repository.BookRepository;
import com.dhiraj.app.service.IBookService;

@Transactional
@Service
public class BookServiceImpl implements IBookService {

	private BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public Book createBook(Book book) {
		Book savedBook = bookRepository.save(book);
		if (savedBook != null)
			return savedBook;
		else
			throw new BusinessException("Error creating new Book.");
	}

	@Override
	public Book getBookById(long id) {
		Optional<Book> optional = bookRepository.findById(id);
		Book book = optional.isPresent() && optional.get().getActive() == Active.TRUE ? optional.get()
				: optional.orElseThrow(() -> new BusinessException("Book Not Found."));
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		if (!books.isEmpty()) {
			return books;
		} else {
			throw new BusinessException("Book not Found. List is Empty.");
		}
	}

	@Override
	public List<Book> getAllBooksByActive(Active active) {
		List<Book> books = bookRepository.findBooksByActive(active);
		if (!books.isEmpty()) {
			return books;
		} else {
			throw new BusinessException("Book not Found for Active: " + active + ". List is Empty.");
		}
	}

	@Override
	public List<Book> getAllBooksByAuthor(String author) {
		List<Book> books = bookRepository.findBooksByAuthor(author);
		if (!books.isEmpty()) {
			return books.stream().filter(b -> b.getActive() == Active.TRUE).collect(Collectors.toList());
		} else {
			throw new BusinessException("Book not Found for Author: " + author + ". List is Empty.");
		}
	}

	@Override
	public List<Book> getAllBooksByPublication(String publication) {
		List<Book> books = bookRepository.findBooksByPublication(publication);
		if (!books.isEmpty()) {
			return books.stream().filter(b -> b.getActive() == Active.TRUE).collect(Collectors.toList());
		} else {
			throw new BusinessException("Book not Found for Publication: " + publication + ". List is Empty.");
		}
	}

	@Override
	public List<Book> getAllBooksByTitle(String title) {
		List<Book> books = bookRepository.findBookByTitle(title);
		if (!books.isEmpty()) {
			return books.stream().filter(b -> b.getActive() == Active.TRUE).collect(Collectors.toList());
		} else {
			throw new BusinessException("Book not Found for Title: " + title + ". List is Empty.");
		}
	}

	@Override
	public Book updateBook(long id, Book book) {

		Book toUpdate = getBookById(id);

		toUpdate.setTitle(book.getTitle());
		toUpdate.setAuthor(book.getAuthor());
		toUpdate.setPublication(book.getPublication());
		toUpdate.setPages(book.getPages());
		toUpdate.setPrice(book.getPrice());
		toUpdate.setCopies(book.getCopies());
		toUpdate.setActive(book.getActive());

		return toUpdate;
	}

	@Override
	public void deleteBookByid(long id) {
		Optional<Book> optional = bookRepository.findById(id);
		if (optional.isPresent()) {
			optional.get().setActive(Active.FALSE);
			updateBook(id, optional.get());
		} else
			optional.orElseThrow(() -> new BusinessException("Book Not Found."));
	}
}
