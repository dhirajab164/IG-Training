package com.dhiraj.app.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.exception.BusinessException;
import com.dhiraj.app.exception.ErrorMessage;
import com.dhiraj.app.exception.ResourceNotFoundException;
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
	public ResponseEntity<?> getAllBooksByActive(@PathVariable int active) {
		if (active == 0 || active == 1) {
			List<Book> books = bookService.getAllBooksByActive(active);
			return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		} else {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Incorrect Id sent.").description("Id should be 0 or 1. 0=Inactive, 1=Active").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getBookById(@PathVariable long id) {
		if (id != 0) {
			Book book = bookService.getBookById(id);
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		} else {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Incorrect Id sent.").description("Id should be greater than zero").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/author/{author}")
	public ResponseEntity<?> getAllBooksByAuthor(@PathVariable String author) {
		if (author != null || !author.isEmpty()) {
			List<Book> books = bookService.getAllBooksByAuthor(author);
			return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		} else {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Author cannot be empty or null.").description("Author sent is empty or null.").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/title/{title}")
	public ResponseEntity<?> getAllBooksByTitle(@PathVariable String title) {
		if (title != null || !title.isEmpty()) {
			List<Book> books = bookService.getAllBooksByTitle(title);
			return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		} else {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Title cannot be empty or null.").description("Title sent is empty or null.").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/publication/{publication}")
	public ResponseEntity<?> getAllBooksByPublication(@PathVariable String publication) {
		if (publication != null || !publication.isEmpty()) {
			List<Book> books = bookService.getAllBooksByPublication(publication);
			return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		} else {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Publication cannot be empty or null.").description("Publication sent is empty or null.")
					.build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/book")
	public ResponseEntity<?> createBook(@RequestBody Book book) {
		if (book != null) {
			Book createdBook = bookService.createBook(book);
			return new ResponseEntity<Book>(createdBook, HttpStatus.CREATED);
		} else {
			ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), LocalDate.now(),
					"Book is Empty.", "Empty Object sent to save.");
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@PatchMapping("/book/{id}")
	public ResponseEntity<?> updateBook(@PathVariable long id, @RequestBody Book book) {
		if (id <= 0) {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Incorrect Id sent.").description("Id should be greater than zero").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		} else if (bookService.getBookById(id) != null && book != null) {
			Book updateBook = bookService.updateBook(id, book);
			return new ResponseEntity<Book>(updateBook, HttpStatus.ACCEPTED);
		} else {
			ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), LocalDate.now(),
					"Book is Empty.", "Empty Object sent to save.");
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<?> deleteBookById(long id) {
		if (id <= 0) {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Incorrect Id sent.").description("Id should be greater than zero").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		} else if (bookService.getBookById(id) != null) {
			bookService.deleteBookByid(id);
			return new ResponseEntity<String>("Book Deleted with id: " + id, HttpStatus.NO_CONTENT);
		} else {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.NOT_FOUND.value())
					.message("Book not Found.").description("Book with ID: " + id + " not Available.").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}
}
