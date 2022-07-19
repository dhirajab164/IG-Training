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
import org.springframework.test.context.ActiveProfiles;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.entity.BookIssue;
import com.dhiraj.app.entity.User;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.entity.enums.BookIssueStatus;
import com.dhiraj.app.entity.enums.Gender;
import com.dhiraj.app.entity.enums.UserType;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class BookIssueRepositoryTest {

	@Autowired
	private BookIssueRepository bookIssueRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	
	BookIssue bookIssue;
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

		bookIssue = BookIssue.builder().id(1l).book(book).issuedTo(customer).issuedBy(librarian).issuedOn(now)
				.toBeReturnedOn(nowPlus3Days).status(BookIssueStatus.PENDING).active(Active.TRUE).build();
		userRepository.save(customer);
		userRepository.save(librarian);
		bookRepository.save(book);
		bookIssueRepository.save(bookIssue);
	}

	@DisplayName("Test for bookIssue by id")
	@Test
	public void findByIdTest() {
		BookIssue bookIssueById = bookIssueRepository.findById(bookIssue.getId()).get();
		System.out.println("IssueById: " + bookIssueById);

		assertThat(bookIssueById.getStatus()).isEqualTo(bookIssue.getStatus());
	}

	@DisplayName("Test for get all bookIssues")
	@Test
	public void findAllTest() {
		List<BookIssue> bookIssues = bookIssueRepository.findAll();

		assertThat(bookIssues).isNotNull();
		assertThat(bookIssues.size()).isEqualTo(1);
	}

	@DisplayName("Test for bookIssue save")
	@Test
	public void bookIssueSaveTest() {

		BookIssue savedbookIssue = bookIssueRepository.save(bookIssue);
		assertThat(savedbookIssue).isNotNull();
		assertThat(savedbookIssue.getId()).isGreaterThan(0);
	}

	@DisplayName("Test for bookIssue update")
	@Test
	public void bookIssueUpdateTest() {

		BookIssue savedbookIssue = bookIssueRepository.findById(bookIssue.getId()).get();
		BookIssueStatus status = BookIssueStatus.APPROVED;
		savedbookIssue.setStatus(status);

		assertThat(savedbookIssue.getStatus()).isEqualTo(status);
	}

}
