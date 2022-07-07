package com.dhiraj.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
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
		book = new Book(1, "Title 1", "Author 1", "Publication 1", 120, 150.0, 50, Active.TRUE, user, LocalDate.now(),
				user, LocalDate.now());
	}

	@Test
	public void getAllBooksTest() {
		List<Book> books = Arrays.asList(
				new Book(1, "Title 1", "Author 1", "Publication 1", 120, 150.0, 50, Active.TRUE, user, LocalDate.now(),
						user, LocalDate.now()),
				new Book(2, "Title 2", "Author 2", "Publication 2", 120, 150.0, 50, Active.TRUE, user, LocalDate.now(),
						user, LocalDate.now()),
				new Book(3, "Title 3", "Author 3", "Publication 3", 120, 150.0, 50, Active.TRUE, user, LocalDate.now(),
						user, LocalDate.now()),
				new Book(4, "Title 4", "Author 4", "Publication 4", 120, 150.0, 50, Active.TRUE, user, LocalDate.now(),
						user, LocalDate.now()),
				new Book(5, "Title 5", "Author 5", "Publication 5", 120, 150.0, 50, Active.TRUE, user, LocalDate.now(),
						user, LocalDate.now()),
				new Book(6, "Title 4", "Author 4", "Publication 4", 120, 150.0, 50, Active.TRUE, user, LocalDate.now(),
						user, LocalDate.now()));

		when(bookRepository.findAll()).thenReturn(books);

		List<Book> list = bookService.getAllBooks();

		assertEquals(6, list.size());
	}

	@Test
	public void getBookByIdTest() {
		when(bookRepository.findById(1l)).thenReturn(Optional.of(book));

		Book b = bookService.getBookById(1l);

		assertEquals("Title 1", b.getTitle());
	}

	@Test
	public void getAllBooksByAuthorTest() {
		when(bookRepository.findBooksByAuthor("Author 1")).thenReturn(Arrays.asList(book));

		List<Book> allBooksByAuthor = bookService.getAllBooksByAuthor("Author 1");

		assertEquals(1, allBooksByAuthor.size());
	}

	@Test
	public void getAllBooksByPublicationTest() {
		when(bookRepository.findBooksByPublication("Publication 1")).thenReturn(Arrays.asList(book));

		List<Book> allBooksByPublication = bookService.getAllBooksByPublication("Publication 1");

		assertEquals(1, allBooksByPublication.size());
	}

	@Test
	public void getAllBooksByTitleTest() {
		when(bookRepository.findBookByTitle("Title 1")).thenReturn(Arrays.asList(book));

		List<Book> allBooksByTitle = bookService.getAllBooksByTitle("Title 1");

		assertEquals(1, allBooksByTitle.size());
	}

	@Test
	public void deleteBookByidTest() {
		Book book = new Book();
		book.setId(1);
		
		when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));

		bookService.deleteBookByid(1l);
		verify(bookRepository).deleteById(1l);
	}

	@Test
	public void createBookTest() {
		Book b = new Book("Title 1", "Author 1", "Publication 1", 120, 150.0, 50, Active.TRUE, user, LocalDate.now(),
				user, LocalDate.now());
		when(bookRepository.save(b)).thenReturn(book);

		Book newBook = bookService.createBook(Optional.of(b));
		assertEquals(1, newBook.getId());
	}

}
