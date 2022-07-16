package com.dhiraj.app.controller;

import java.time.LocalDate;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.app.entity.BookIssue;
import com.dhiraj.app.entity.enums.BookIssueStatus;
import com.dhiraj.app.exception.ErrorMessage;
import com.dhiraj.app.service.IBookIssueService;

@RestController
@RequestMapping("api/book_issues")
public class BookIssueController {
	private IBookIssueService bookIssueService;

	public BookIssueController(IBookIssueService bookIssueService) {
		super();
		this.bookIssueService = bookIssueService;
	}

	@GetMapping
	public ResponseEntity<List<BookIssue>> getAllBookIssues() {
		List<BookIssue> BookIssues = bookIssueService.getAllBookIssues();
		return new ResponseEntity<List<BookIssue>>(BookIssues, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getBookIssueById(@PathVariable long id) {
		if (id != 0) {
			BookIssue bookIssue = bookIssueService.getBookIssueById(id);
			return new ResponseEntity<BookIssue>(bookIssue, HttpStatus.OK);
		} else {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Incorrect Id sent.").description("Id should be greater than zero").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/status/{status}")
	public ResponseEntity<?> getAllBookIssuesByAuthor(@PathVariable int status) {
		if (status >= 0 || status <= 2) {
			List<BookIssue> BookIssues = bookIssueService.getAllBookIssuesByStatus(BookIssueStatus.of(status));
			return new ResponseEntity<List<BookIssue>>(BookIssues, HttpStatus.OK);
		} else {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Incorrect Id sent.")
					.description("ID should between 0-2. 0=PENDING, 1=APPROVED, 2=REJECTED.").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/book_issue")
	public ResponseEntity<?> createBookIssue(@RequestBody BookIssue bookIssue) {
		if (bookIssue != null) {
			BookIssue createdBookIssue = bookIssueService.createBookIssue(bookIssue);
			return new ResponseEntity<BookIssue>(createdBookIssue, HttpStatus.CREATED);
		} else {
			ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), LocalDate.now(),
					"Book is Empty.", "Empty Object sent to save.");
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/book_issue") // #lib/user/book
	public ResponseEntity<?> updateBookIssue(@RequestBody BookIssue bookIssue) {
		if (bookIssueService.getBookIssueById(bookIssue.getId()) != null && bookIssue != null) {
			BookIssue updateBookIssue = bookIssueService.updateBookIssue(bookIssue);
			return new ResponseEntity<BookIssue>(updateBookIssue, HttpStatus.ACCEPTED);
		} else {
			ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), LocalDate.now(),
					"BookIssue is Empty.", "Empty Object sent to save.");
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@PatchMapping("/book_issue/{id}/{user_id}")
	public ResponseEntity<?> patchBookIssue(@PathVariable long id, @PathVariable long user_id,
			@RequestBody BookIssue bookIssue) {
		if (id <= 0) {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Incorrect Id sent.").description("Id should be greater than zero").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		} else if (bookIssueService.getBookIssueById(id) != null && bookIssue != null) {
			BookIssue updateBookIssue = bookIssueService.patchBookIssue(id, bookIssue);
			return new ResponseEntity<BookIssue>(updateBookIssue, HttpStatus.ACCEPTED);
		} else {
			ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), LocalDate.now(),
					"BookIssue is Empty.", "Empty Object sent to save.");
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/book_issue/{id}")
	public ResponseEntity<?> deleteBookIssueById(@PathVariable long id) {
		if (id <= 0) {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Incorrect Id sent.").description("Id should be greater than zero").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		} else if (bookIssueService.getBookIssueById(id) != null) {
			bookIssueService.deleteBookIssueById(id);
			return new ResponseEntity<String>("BookIssue Deleted with id: " + id, HttpStatus.NO_CONTENT);
		} else {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.NOT_FOUND.value())
					.message("BookIssue not Found.").description("BookIssue with ID: " + id + " not Available.")
					.build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}
}
