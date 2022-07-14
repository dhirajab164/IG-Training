package com.dhiraj.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.entity.Transaction;
import com.dhiraj.app.entity.User;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.entity.enums.Gender;
import com.dhiraj.app.entity.enums.TransactionStatus;
import com.dhiraj.app.entity.enums.UserType;
import com.dhiraj.app.repository.TransactionRepository;
import com.dhiraj.app.service.impl.TransactionServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

	@Mock
	private TransactionRepository transactionRepository;

	@InjectMocks
	private TransactionServiceImpl transactionService;

	Transaction transaction;
	Book book;
	User customer;
	User librarian;

	LocalDate now = LocalDate.now();
	LocalDate nowPlus3Days = now.plusDays(3);
	
	@BeforeEach
	public void init() {

		customer = User.builder().firstName("John").lastName("Doe").age(26).gender(Gender.M).email("john@mail.com")
				.phone("1231231231").city("city").type(UserType.Customer).active(Active.TRUE).build();
		librarian = User.builder().firstName("Jane").lastName("Doe").age(26).gender(Gender.F).email("jane@mail.com")
				.phone("2342342342").city("city").type(UserType.Librarian).active(Active.TRUE).build();

		book = Book.builder().id(1l).title("Title 1").author("Author 1").publication("Publication 1").pages(120)
				.price(150.0).copies(100).active(Active.TRUE).createdBy(librarian).createdOn(LocalDate.now())
				.updatedBy(librarian).updatedOn(LocalDate.now()).build();

		transaction = Transaction.builder().book(book).issuedTo(customer).issuedBy(librarian).issuedOn(now)
				.toBeReturnedOn(nowPlus3Days).build();

	}

	@DisplayName("Test get all transactions")
	@Test
	public void getAllTransactionsTest() {
		List<Transaction> transactions = Arrays.asList(transaction);

		when(transactionRepository.findAll()).thenReturn(transactions);

		List<Transaction> list = transactionService.getAllTransactions();

		assertEquals(1, list.size());
	}

	@DisplayName("Test get transaction by id")
	@Test
	public void getTransactionByIdTest() {
		when(transactionRepository.findById(1l)).thenReturn(Optional.of(transaction));

		Transaction tr = transactionService.getTransactionById(1l);

		assertThat(tr.getBook().getTitle()).isEqualTo(book.getTitle());
	}

	@DisplayName("Test delete Transaction by id")
	@Test
	public void deleteTransactionByIdTest() {

		when(transactionRepository.findById(transaction.getId())).thenReturn(Optional.of(transaction));

		transactionService.deleteTransactionById(transaction.getId());
		assertEquals(Active.FALSE, transaction.getActive());
	}

	@DisplayName("Test create transaction")
	@Test
	public void transactionCreateTest() {
		Transaction savedTr = Transaction.builder().id(1).book(book).issuedTo(customer).issuedBy(librarian).issuedOn(now)
				.toBeReturnedOn(nowPlus3Days).build();
		when(transactionRepository.save(transaction)).thenReturn(savedTr);

		Transaction tr = transactionService.createTransaction(transaction);
		assertThat(tr.getId()).isGreaterThan(0);
	}
	
	@DisplayName("Test to transaction update")
	@Test
	public void updateTransactionTest() {
		transactionRepository.save(transaction);
		TransactionStatus status = TransactionStatus.APPROVED;

		when(transactionRepository.findById(transaction.getId())).thenReturn(Optional.of(transaction));
		transaction.setStatus(status);

		Transaction updatedTransaction = transactionService.updateTransaction(transaction.getId(), transaction);
		assertThat(updatedTransaction.getStatus()).isEqualTo(status);

	}
}
