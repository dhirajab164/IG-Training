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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.app.entity.Transaction;
import com.dhiraj.app.exception.ErrorMessage;
import com.dhiraj.app.service.ITransactionService;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {
	private ITransactionService transactionService;

	public TransactionController(ITransactionService transactionService) {
		super();
		this.transactionService = transactionService;
	}

	@GetMapping
	public ResponseEntity<List<Transaction>> getAllTransactions() {
		List<Transaction> Transactions = transactionService.getAllTransactions();
		return new ResponseEntity<List<Transaction>>(Transactions, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getTransactionById(@PathVariable long id) {
		if (id != 0) {
			Transaction transaction = transactionService.getTransactionById(id);
			return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
		} else {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Incorrect Id sent.").description("Id should be greater than zero").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/status/{status}")
	public ResponseEntity<?> getAllTransactionsByAuthor(@PathVariable int status) {
		if (status >= 0 || status <= 2) {
			List<Transaction> Transactions = transactionService.getAllTransactionsByStatus(status);
			return new ResponseEntity<List<Transaction>>(Transactions, HttpStatus.OK);
		} else {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Incorrect Id sent.")
					.description("ID should between 0-2. 0=PENDING, 1=APPROVED, 2=REJECTED.").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/transaction")
	public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction) {
		if (transaction != null) {
			Transaction createdTransaction = transactionService.createTransaction(transaction);
			return new ResponseEntity<Transaction>(createdTransaction, HttpStatus.CREATED);
		} else {
			ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), LocalDate.now(),
					"Book is Empty.", "Empty Object sent to save.");
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@PatchMapping("/transaction/{id}")
	public ResponseEntity<?> updateTransaction(@PathVariable long id, @RequestBody Transaction transaction) {
		if (id <= 0) {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Incorrect Id sent.").description("Id should be greater than zero").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		} else if (transactionService.getTransactionById(id) != null && transaction != null) {
			Transaction updateTransaction = transactionService.updateTransaction(id, transaction);
			return new ResponseEntity<Transaction>(updateTransaction, HttpStatus.ACCEPTED);
		} else {
			ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), LocalDate.now(),
					"Transaction is Empty.", "Empty Object sent to save.");
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/transaction/{id}")
	public ResponseEntity<?> deleteTransactionById(long id) {
		if (id <= 0) {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Incorrect Id sent.").description("Id should be greater than zero").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		} else if (transactionService.getTransactionById(id) != null) {
			transactionService.deleteTransactionById(id);
			return new ResponseEntity<String>("Transaction Deleted with id: " + id, HttpStatus.NO_CONTENT);
		} else {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.NOT_FOUND.value())
					.message("Transaction not Found.").description("Transaction with ID: " + id + " not Available.")
					.build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}
}
