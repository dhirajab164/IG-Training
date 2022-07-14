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
import com.dhiraj.app.entity.Transaction;
import com.dhiraj.app.entity.User;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.entity.enums.Gender;
import com.dhiraj.app.entity.enums.TransactionStatus;
import com.dhiraj.app.entity.enums.UserType;
import com.dhiraj.app.service.ITransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ITransactionService transactionService;

	@Autowired
	private ObjectMapper objectMapper;

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
				.toBeReturnedOn(nowPlus3Days).build();

	}

	@DisplayName("Test get all transactions")
	@Test
	public void getAllTransactionsTest() throws Exception {

		List<Transaction> transactions = Arrays.asList(transaction);

		when(transactionService.getAllTransactions()).thenReturn(transactions);

		ResultActions response = mockMvc.perform(get("/api/transactions").contentType(MediaType.APPLICATION_JSON));

		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(transactions.size())));
	}

	@DisplayName("Test to get transaction by id")
	@Test
	public void getTransactionByIdTest() throws Exception {

		long transactionId = 1;
		when(transactionService.getTransactionById(transactionId)).thenReturn(transaction);

		ResultActions response = mockMvc
				.perform(get("/api/transactions/{id}", transactionId).contentType(MediaType.APPLICATION_JSON));

		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.book.title", is("Title 1")))
				.andExpect(jsonPath("$.issuedTo.type", is("Customer")));
	}

	@DisplayName("Test to create transaction")
	@Test
	public void creaTetransactionTest() throws JsonProcessingException, Exception {
		when(transactionService.createTransaction(transaction)).thenReturn(transaction);

		ResultActions response = mockMvc.perform(post("/api/transactions/transaction")
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(transaction)));

		response.andDo(print()).andExpect(status().isCreated()).andExpect(jsonPath("$.book.title", is("Title 1")));
	}

	@DisplayName("Test to update transaction")
	@Test
	public void updateTransactionTest() throws JsonProcessingException, Exception {

		transaction = Transaction.builder().id(1l).book(book).issuedTo(customer).issuedBy(librarian).issuedOn(now)
				.toBeReturnedOn(nowPlus3Days).status(TransactionStatus.PENDING).build();

		when(transactionService.getTransactionById(transaction.getId())).thenReturn(transaction);

		Transaction updatedTansaction = Transaction.builder().id(1l).book(book).issuedTo(customer).issuedBy(librarian)
				.issuedOn(now).toBeReturnedOn(nowPlus3Days).status(TransactionStatus.APPROVED).build();

		when(transactionService.updateTransaction(transaction.getId(), transaction)).thenReturn(updatedTansaction);
		ResultActions response = mockMvc.perform(patch("/api/transactions/transaction/{id}", transaction.getId())
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(transaction)));

		response.andDo(print()).andExpect(status().isAccepted())
				.andExpect(jsonPath("$.status", is("APPROVED")));
	}

	@DisplayName("Test to delete transaction")
	@Test
	public void deleteTransactionById() throws Exception {

		when(transactionService.getTransactionById(1L)).thenReturn(transaction);
		BDDMockito.willDoNothing().given(transactionService).deleteTransactionById(1L);

		ResultActions response = mockMvc.perform(delete("/api/transactions/transaction/{id}", 1L));

		response.andExpect(status().isNoContent()).andDo(print());
	}

}
