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
import org.mockito.BDDMockito.*;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.entity.BookIssue;
import com.dhiraj.app.entity.User;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.entity.enums.BookIssueStatus;
import com.dhiraj.app.entity.enums.Gender;
import com.dhiraj.app.entity.enums.UserType;
import com.dhiraj.app.repository.BookIssueRepository;
import com.dhiraj.app.service.impl.BookIssueServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BookIssueServiceTest {

	@Mock
	private BookIssueRepository bookIssueRepository;

	@InjectMocks
	private BookIssueServiceImpl bookIssueService;

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

		bookIssue = BookIssue.builder().id(1).book(book).issuedTo(customer).issuedBy(librarian).issuedOn(now)
				.active(Active.TRUE).toBeReturnedOn(nowPlus3Days).build();

	}

	@DisplayName("Test get all BookIssues")
	@Test
	public void getAllBookIssuesTest() {
		BookIssue bookIssue1 = BookIssue.builder().id(1).book(book).issuedTo(customer).issuedBy(librarian).issuedOn(now)
				.active(Active.TRUE).toBeReturnedOn(nowPlus3Days).build();
		List<BookIssue> bookIssues = Arrays.asList(bookIssue, bookIssue1);

		when(bookIssueRepository.findAll()).thenReturn(bookIssues);

		List<BookIssue> list = bookIssueService.getAllBookIssues();

		assertThat(list.size()).isEqualTo(2);
	}

	@DisplayName("Test get bookIssue by id")
	@Test
	public void getBookIssueByIdTest() {
		when(bookIssueRepository.findById(1l)).thenReturn(Optional.of(bookIssue));

		BookIssue bookIssueById = bookIssueService.getBookIssueById(1l);

		assertThat(bookIssueById.getBook().getTitle()).isEqualTo(book.getTitle());
	}

	@DisplayName("Test delete BookIssue by id")
	@Test
	public void deleteBookIssueByIdTest() {

		when(bookIssueRepository.findById(bookIssue.getId())).thenReturn(Optional.of(bookIssue));

		bookIssueService.deleteBookIssueById(bookIssue.getId());
		assertEquals(Active.FALSE, bookIssue.getActive());
	}

	@DisplayName("Test create bookIssue")
	@Test
	public void BookIssueCreateTest() {
		BookIssue savedTr = BookIssue.builder().id(1).book(book).issuedTo(customer).issuedBy(librarian).issuedOn(now)
				.toBeReturnedOn(nowPlus3Days).build();
		when(bookIssueRepository.save(bookIssue)).thenReturn(savedTr);

		BookIssue tr = bookIssueService.createBookIssue(bookIssue);
		assertThat(tr.getId()).isGreaterThan(0);
	}

	@DisplayName("Test to bookIssue update")
	@Test
	public void updateBookIssueTest() {
		bookIssueRepository.save(bookIssue);
		BookIssueStatus status = BookIssueStatus.APPROVED;

		when(bookIssueRepository.findById(bookIssue.getId())).thenReturn(Optional.of(bookIssue));
		bookIssue.setStatus(status);

		BookIssue updatedBookIssue = bookIssueService.updateBookIssue(bookIssue);
		assertThat(updatedBookIssue.getStatus()).isEqualTo(status);
	}
}
