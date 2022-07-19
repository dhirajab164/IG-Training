package com.dhiraj.app.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import com.dhiraj.app.entity.BookIssue;
import com.dhiraj.app.entity.User;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.entity.enums.BookIssueStatus;
import com.dhiraj.app.entity.enums.Gender;
import com.dhiraj.app.entity.enums.UserType;
import com.dhiraj.app.service.IBookIssueService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(BookIssueController.class)
public class BookIssueControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IBookIssueService bookIssueService;

	@Autowired
	private ObjectMapper objectMapper;

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
				.toBeReturnedOn(nowPlus3Days).build();

	} 

	@DisplayName("Test get all BookIssues")
	@Test
	public void getAllBookIssuesTest() throws Exception {

		List<BookIssue> bookIssues = Arrays.asList(bookIssue);

		when(bookIssueService.getAllBookIssues()).thenReturn(bookIssues);

		ResultActions response = mockMvc.perform(get("/api/book_issues").contentType(MediaType.APPLICATION_JSON));

		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(bookIssues.size())));
	}

	@DisplayName("Test to get bookIssue by id")
	@Test
	public void getBookIssueByIdTest() throws Exception {

		long bookIssueId = 1;
		when(bookIssueService.getBookIssueById(bookIssueId)).thenReturn(bookIssue);

		ResultActions response = mockMvc
				.perform(get("/api/book_issues/{id}", bookIssueId).contentType(MediaType.APPLICATION_JSON));

		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.book.title", is("Title 1")))
				.andExpect(jsonPath("$.issuedTo.type", is("Customer")));
	}

	@DisplayName("Test to create bookIssue")
	@Test
	public void creaTeBookIssueTest() throws JsonProcessingException, Exception {
		when(bookIssueService.createBookIssue(bookIssue)).thenReturn(bookIssue);

		ResultActions response = mockMvc.perform(post("/api/book_issues/book_issue")
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(bookIssue)));

		response.andDo(print()).andExpect(status().isCreated()).andExpect(jsonPath("$.book.title", is("Title 1")));
	}

	@DisplayName("Test to update bookIssue")
	@Test
	public void updateBookIssueTest() throws JsonProcessingException, Exception {

		bookIssue = BookIssue.builder().id(1l).book(book).issuedTo(customer).issuedBy(librarian).issuedOn(now)
				.toBeReturnedOn(nowPlus3Days).status(BookIssueStatus.PENDING).build();

		when(bookIssueService.getBookIssueById(bookIssue.getId())).thenReturn(bookIssue);

		BookIssue updatedBookIssue = BookIssue.builder().id(1l).book(book).issuedTo(customer).issuedBy(librarian)
				.issuedOn(now).toBeReturnedOn(nowPlus3Days).status(BookIssueStatus.APPROVED).build();

		when(bookIssueService.updateBookIssue(bookIssue)).thenReturn(updatedBookIssue);
		ResultActions response = mockMvc.perform(put("/api/book_issues/book_issue")
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(bookIssue)));

		response.andDo(print()).andExpect(status().isAccepted()).andExpect(jsonPath("$.status", is("APPROVED")));
	}

	@DisplayName("Test to delete bookIssue")
	@Test
	public void deleteBookIssueById() throws Exception {

		when(bookIssueService.getBookIssueById(1L)).thenReturn(bookIssue);
		BDDMockito.willDoNothing().given(bookIssueService).deleteBookIssueById(1L);

		ResultActions response = mockMvc.perform(delete("/api/book_issues/book_issue/{id}", 1L));

		response.andExpect(status().isNoContent()).andDo(print());
	}

}
