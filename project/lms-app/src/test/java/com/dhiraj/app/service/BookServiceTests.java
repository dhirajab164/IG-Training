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
import com.dhiraj.app.entity.User;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.repository.BookRepository;
import com.dhiraj.app.service.impl.BookServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BookServiceTests {

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookServiceImpl bookService;

	private Book book;
	private User user;

	@BeforeEach
	private void init() {
		book = Book.builder().id(1l).title("Title 1").author("Author 1").publication("Publication 1").pages(120)
				.price(150.0).copies(100).active(Active.TRUE).createdBy(user).createdOn(LocalDate.now()).updatedBy(user)
				.updatedOn(LocalDate.now()).build();
	}

	
	@DisplayName("Test to get all books ")
	@Test
	public void getAllBooksTest() {
		List<Book> books = Arrays.asList(book);

		when(bookRepository.findAll()).thenReturn(books);

		List<Book> list = bookService.getAllBooks();

		assertEquals(1, list.size());
	}

	@DisplayName("Test to get book by id ")
	@Test
	public void getBookByIdTest() {
		when(bookRepository.findById(1l)).thenReturn(Optional.of(book));

		Book b = bookService.getBookById(1l);

		assertEquals("Title 1", b.getTitle());
	}

	@DisplayName("Test to get all books by author")
	@Test
	public void getAllBooksByAuthorTest() {
		when(bookRepository.findBooksByAuthor("Author 1")).thenReturn(Arrays.asList(book));

		List<Book> allBooksByAuthor = bookService.getAllBooksByAuthor("Author 1");

		assertEquals(1, allBooksByAuthor.size());
	}

	@DisplayName("Test to get all books by publication")
	@Test
	public void getAllBooksByPublicationTest() {
		when(bookRepository.findBooksByPublication("Publication 1")).thenReturn(Arrays.asList(book));

		List<Book> allBooksByPublication = bookService.getAllBooksByPublication("Publication 1");

		assertEquals(1, allBooksByPublication.size());
	}

	@DisplayName("Test to get all books by title ")
	@Test
	public void getAllBooksByTitleTest() {
		when(bookRepository.findBookByTitle("Title 1")).thenReturn(Arrays.asList(book));

		List<Book> allBooksByTitle = bookService.getAllBooksByTitle("Title 1");

		assertEquals(1, allBooksByTitle.size());
	}

	@DisplayName("Test to delete book by id")
	@Test
	public void deleteBookByidTest() {

		when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));

		bookService.deleteBookByid(book.getId());

		assertThat(Active.FALSE).isEqualTo(book.getActive());
	}

	@DisplayName("Test to create book")
	@Test
	public void createBookTest() {
		Book b = new Book("Title 1", "Author 1", "Publication 1", 120, 150.0, 50, user, user);
		when(bookRepository.save(b)).thenReturn(book);

		Book newBook = bookService.createBook(b);
		assertEquals(1, newBook.getId());
	}
	
	

}
