package com.dhiraj.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.service.IBookService;

@RestController
@RequestMapping("api/books")
public class BookController {

	private IBookService bookService;

	public BookController(IBookService bookService) {
		super();
		this.bookService = bookService;
	}

	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = bookService.getAllBooks();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@GetMapping("/active/{active}")
	public ResponseEntity<List<Book>> getAllBooksByActive(@PathVariable int active) {
		List<Book> books = bookService.getAllBooksByActive(active);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable long id) {
		Book book = bookService.getBookById(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@GetMapping("/author/{author}")
	public ResponseEntity<List<Book>> getAllBooksByAuthor(@PathVariable String author) {
		List<Book> books = bookService.getAllBooksByAuthor(author);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<List<Book>> getAllBooksByTitle(@PathVariable String title) {
		List<Book> books = bookService.getAllBooksByTitle(title);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@GetMapping("/publication/{publication}")
	public ResponseEntity<List<Book>> getAllBooksByPublication(@PathVariable String publication) {
		List<Book> books = bookService.getAllBooksByPublication(publication);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@PostMapping("/book")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		Book createdBook = bookService.createBook(Optional.of(book));
		return new ResponseEntity<Book>(createdBook, HttpStatus.CREATED);
	}

	@PatchMapping("/book/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book book) {
		Book updateBook = bookService.updateBook(id, Optional.of(book));
		return new ResponseEntity<Book>(updateBook, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<String> deleteBookByid(long id) {
		bookService.deleteBookByid(id);
		return new ResponseEntity<String>("Book Deleted with id: " + id, HttpStatus.NO_CONTENT);
	}
}
