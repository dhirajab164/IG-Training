package com.dhiraj.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.exception.BusinessException;
import com.dhiraj.app.repository.BookRepository;
import com.dhiraj.app.service.IBookService;

@Service
public class BookServiceImpl implements IBookService {

	private BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public Book createBook(Optional<Book> book) {
		if (book.isPresent()) {
			return bookRepository.save(book.get());
		} else {
			throw new BusinessException("Book is Empty.");
		}
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
			throw new BusinessException("Books not Found. List is Empty.");
		}
	}

	@Override
	public List<Book> getAllBooksByActive(int active) {
		List<Book> books = bookRepository.findBooksByActive(active);
		if (!books.isEmpty()) {
			return books;
		} else {
			throw new BusinessException("Books not Found for Active: " + active + ". List is Empty.");
		}
	}

	@Override
	public List<Book> getAllBooksByAuthor(String author) {
		List<Book> books = bookRepository.findBooksByAuthor(author);
		if (!books.isEmpty()) {
			return books.stream().filter(b -> b.getActive() == Active.TRUE).collect(Collectors.toList());
		} else {
			throw new BusinessException("Books not Found for Author: " + author + ". List is Empty.");
		}
	}

	@Override
	public List<Book> getAllBooksByPublication(String publication) {
		List<Book> books = bookRepository.findBooksByPublication(publication);
		if (!books.isEmpty()) {
			return books.stream().filter(b -> b.getActive() == Active.TRUE).collect(Collectors.toList());
		} else {
			throw new BusinessException("Books not Found for Publication: " + publication + ". List is Empty.");
		}
	}

	@Override
	public List<Book> getAllBooksByTitle(String title) {
		List<Book> books = bookRepository.findBookByTitle(title);
		if (!books.isEmpty()) {
			return books.stream().filter(b -> b.getActive() == Active.TRUE).collect(Collectors.toList());
		} else {
			throw new BusinessException("Books not Found for Title: " + title + ". List is Empty.");
		}
	}

	@Override
	public Book updateBook(long id, Optional<Book> book) {
		Optional<Book> optional = bookRepository.findById(id);
		Book toUpdate = null;
		if (optional.isPresent() && book.isPresent()) {
			toUpdate = optional.get();
			toUpdate.setAuthor(book.get().getAuthor());
			toUpdate.setPublication(book.get().getPublication());
			toUpdate.setPages(book.get().getPages());
			toUpdate.setPrice(book.get().getPrice());
			toUpdate.setCopies(book.get().getCopies());
			toUpdate.setActive(book.get().getActive());
			toUpdate.setCreatedBy(book.get().getCreatedBy());
			toUpdate.setUpdatedBy(book.get().getUpdatedBy());
			toUpdate.setCreatedOn(book.get().getCreatedOn());
			toUpdate.setUpdatedOn(book.get().getUpdatedOn());
			createBook(Optional.of(toUpdate));
		} else {
			optional.orElseThrow(() -> new BusinessException("Book Not Found."));
		}
		return toUpdate;
	}

	@Override
	public void deleteBookByid(long id) {
		Optional<Book> optional = bookRepository.findById(id);
		if (optional.isPresent()) {
			optional.get().setActive(Active.FALSE);
			updateBook(id, optional);
		} else
			optional.orElseThrow(() -> new BusinessException("Book Not Found."));
	}
}
