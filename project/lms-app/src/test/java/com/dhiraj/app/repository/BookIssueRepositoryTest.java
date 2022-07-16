package com.dhiraj.app.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.entity.Transaction;
import com.dhiraj.app.entity.User;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.entity.enums.Gender;
import com.dhiraj.app.entity.enums.TransactionStatus;
import com.dhiraj.app.entity.enums.UserType;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TransactionRepositoryTest {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

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

		transaction = Transaction.builder().id(1l).book(book).issuedTo(customer).issuedBy(librarian).issuedOn(now)
				.toBeReturnedOn(nowPlus3Days).status(TransactionStatus.PENDING).active(Active.TRUE).build();
		userRepository.save(customer);
		userRepository.save(librarian);
		bookRepository.save(book);
		transactionRepository.save(transaction);
	}

	@DisplayName("Test for transaction by id")
	@Test
	public void findByIdTest() {
		Transaction transactionById = transactionRepository.findById(transaction.getId()).get();
		System.out.println("transactionById: " + transactionById);

		assertThat(transactionById.getStatus()).isEqualTo(transaction.getStatus());
	}

	@DisplayName("Test for get all transactions")
	@Test
	public void findAllTest() {
		List<Transaction> transactions = transactionRepository.findAll();

		assertThat(transactions).isNotNull();
		assertThat(transactions.size()).isEqualTo(1);
	}

	@DisplayName("Test for transaction save")
	@Test
	public void transactionSaveTest() {

		Transaction savedTransaction = transactionRepository.save(transaction);
		assertThat(savedTransaction).isNotNull();
		assertThat(savedTransaction.getId()).isGreaterThan(0);
	}

	@DisplayName("Test for transaction update")
	@Test
	public void transactionUpdateTest() {

		Transaction savedtransaction = transactionRepository.findById(transaction.getId()).get();
		TransactionStatus status = TransactionStatus.APPROVED;
		savedtransaction.setStatus(status);

		assertThat(savedtransaction.getStatus()).isEqualTo(status);
	}

}
