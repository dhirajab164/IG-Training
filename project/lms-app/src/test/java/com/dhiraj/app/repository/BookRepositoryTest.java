package com.dhiraj.app.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.entity.User;
import com.dhiraj.app.entity.enums.Active;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
public class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;

	private Book book;
	private User user;

	@BeforeEach
	public void init() {
		book = Book.builder().title("Title 1").author("Author 1").publication("Publication 1").pages(120).price(150.0)
				.copies(100).active(Active.TRUE).createdBy(user).createdOn(LocalDate.now()).updatedBy(user)
				.updatedOn(LocalDate.now()).build();
		Book savedBook = bookRepository.save(book);
	}

	@DisplayName("Test for book by id")
	@Test
	public void findByIdTest() {
		Book bookById = bookRepository.findById(book.getId()).get();

		assertThat(bookById.getTitle()).isEqualTo(book.getTitle());
	}

	@DisplayName("Test for get all books")
	@Test
	public void findAllTest() {

		List<Book> books = bookRepository.findAll();

		assertThat(books).isNotNull();
		assertThat(books.size()).isEqualTo(9);
	}

	@DisplayName("Test for book by title")
	@Test
	public void findBookByTitleTest() {
		List<Book> bookByTitle = bookRepository.findBookByTitle("Title 1");
		assertThat(bookByTitle.size()).isEqualTo(1);
		for (Book book : bookByTitle) {
			assertThat(book.getTitle()).isEqualTo("Title 1");
		}
	}

	@DisplayName("Test for book by Author")
	@Test
	public void findBookByAuthorTest() {
		List<Book> booksByAuthor = bookRepository.findBooksByAuthor("Author 1");
		for (Book book : booksByAuthor) {
			assertThat(book.getAuthor()).isEqualTo("Author 1");
		}
	}

	@DisplayName("Test for book by Publication")
	@Test
	public void findBookByPublicationTest() {
		List<Book> booksByPublication = bookRepository.findBooksByPublication("Publication 1");
		for (Book book : booksByPublication) {
			assertThat(book.getPublication()).isEqualTo("Publication 1");
		}
	}

	@DisplayName("Test for book save")
	@Test
	public void bookSaveTest() {
		Book toSave = Book.builder().title("Title 1").author("Author 1").publication("Publication 1").pages(120)
				.price(150.0).copies(100).active(Active.TRUE).createdBy(user).createdOn(LocalDate.now()).updatedBy(user)
				.updatedOn(LocalDate.now()).build();
		Book savedBook = bookRepository.save(toSave);
		assertThat(savedBook).isNotNull();
		assertThat(savedBook.getId()).isGreaterThan(0);
	}

	@DisplayName("Test for book update")
	@Test
	public void bookUpdateTest() {

		Book savedBook = bookRepository.findById(book.getId()).get();
		String title = "Title Updated";
		savedBook.setTitle(title);

		assertThat(savedBook.getTitle()).isEqualTo(title);
	}

}
