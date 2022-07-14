package com.dhiraj.app.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.entity.User;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.service.IBookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IBookService bookService;

	@Autowired
	private ObjectMapper objectMapper;

	private Book book;
	private User user;

	@BeforeEach
	public void init() {
		book = Book.builder().id(1l).title("Title 1").author("Author 1").publication("Publication 1").pages(120)
				.price(150.0).copies(100).active(Active.TRUE).createdBy(user).createdOn(LocalDate.now()).updatedBy(user)
				.updatedOn(LocalDate.now()).build();

	}

	@DisplayName("Test to get all books")
	@Test
	public void getAllBooksTest() throws Exception {

		// given
		List<Book> books = Arrays.asList(book);
		when(bookService.getAllBooks()).thenReturn(books);

		// when
		ResultActions response = mockMvc.perform(get("/api/books").contentType(MediaType.APPLICATION_JSON));

		// then
		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(books.size())));
	}

	@DisplayName("Test to get book by id")
	@Test
	public void getBookByIdTest() throws Exception {
		// given
		long bookId = 1L;
		when(bookService.getBookById(bookId)).thenReturn(book);

		// when
		ResultActions response = mockMvc.perform(get("/api/books/{id}", bookId));

		// then
		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.title", is(book.getTitle())));
	}

	@DisplayName("Test to get all books by author")
	@Test
	public void getAllBooksByAuthorTest() throws Exception {
		// given
		String author = "Author 1";

		List<Book> books = Arrays.asList(book);

		when(bookService.getAllBooksByAuthor(author)).thenReturn(books);

		// when
		ResultActions response = mockMvc.perform(get("/api/books/author/{author}", author));

		// then
		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(books.size())));
	}

	@DisplayName("Test to get all books by title")
	@Test
	public void getAllBooksByTitleTest() throws Exception {
		// given
		String title = "Title 1";

		List<Book> books = Arrays.asList(book);

		when(bookService.getAllBooksByTitle(title)).thenReturn(books);

		// when
		ResultActions response = mockMvc.perform(get("/api/books/title/{title}", title));

		// then
		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(books.size())));
	}

	@DisplayName("Test to get all books by publication")
	@Test
	public void getAllBooksByPublicationTest() throws Exception {
		// given
		String publication = "Publication 1";

		List<Book> books = Arrays.asList(book);

		when(bookService.getAllBooksByPublication(publication)).thenReturn(books);

		// when
		ResultActions response = mockMvc.perform(get("/api/books/publication/{publication}", publication));

		// then
		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(books.size())));
	}

	@DisplayName("Test to create book")
	@Test
	public void createBookTest() throws JsonProcessingException, Exception {
		when(bookService.createBook(book)).thenReturn(book);

		ResultActions response = mockMvc.perform(post("/api/books/book").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(book)));

		response.andDo(print()).andExpect(status().isCreated()).andExpect(jsonPath("$.title", is(book.getTitle())))
				.andExpect(jsonPath("$.author", is(book.getAuthor())))
				.andExpect(jsonPath("$.publication", is(book.getPublication())));
	}

	@DisplayName("Test to update book")
	@Test
	public void updateBookTest() throws JsonProcessingException, Exception {

		book = Book.builder().id(1l).title("Title Updated").author("Author Updated").publication("Publication Updated")
				.pages(120).price(150.0).copies(100).active(Active.TRUE).createdBy(user).createdOn(LocalDate.now())
				.updatedBy(user).updatedOn(LocalDate.now()).build();

		when(bookService.getBookById(book.getId())).thenReturn(book);
		String title = "Title Updated";
		book.setTitle(title);

		Book updatedBook = Book.builder().id(1l).title("Title Updated").author("Author Updated")
				.publication("Publication Updated").pages(120).price(150.0).copies(100).active(Active.TRUE)
				.createdBy(user).createdOn(LocalDate.now()).updatedBy(user).updatedOn(LocalDate.now()).build();

		when(bookService.updateBook(book.getId(), book)).thenReturn(updatedBook);
		ResultActions response = mockMvc.perform(patch("/api/books/book/{id}", book.getId())
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(book)));

		response.andDo(print()).andExpect(status().isAccepted())
				.andExpect(jsonPath("$.title", is(updatedBook.getTitle())))
				.andExpect(jsonPath("$.author", is(updatedBook.getAuthor())))
				.andExpect(jsonPath("$.publication", is(updatedBook.getPublication())));
	}
	
	@DisplayName("Test to delete Book By id")
	@Test
	public void deleteBookByid() throws JsonProcessingException, Exception {
		when(bookService.getBookById(book.getId())).thenReturn(book);
		
		BDDMockito.willDoNothing().given(bookService).deleteBookByid(1L);

		ResultActions response = mockMvc.perform(delete("/api/books/book/{id}", 1L));

		response.andExpect(status().isNoContent()).andDo(print());
	}

}
