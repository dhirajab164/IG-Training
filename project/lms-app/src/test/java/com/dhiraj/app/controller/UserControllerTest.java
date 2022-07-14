package com.dhiraj.app.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.willDoNothing;
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
import com.dhiraj.app.entity.enums.Gender;
import com.dhiraj.app.entity.enums.UserType;
import com.dhiraj.app.service.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserServiceImpl userService;

	@Autowired
	private ObjectMapper objectMapper;

	private User user;

	@BeforeEach
	public void init() {
		user = User.builder().firstName("John").lastName("Doe").age(26).gender(Gender.M).email("john@mail.com")
				.phone("1231231231").city("city").type(UserType.Customer).active(Active.TRUE).build();
	}

	@DisplayName("Test get all users")
	@Test
	public void getAllUsersTest() throws Exception {

		List<User> users = Arrays.asList(user);

		when(userService.getAllUsers()).thenReturn(users);

		ResultActions response = mockMvc.perform(get("/api/users").contentType(MediaType.APPLICATION_JSON));

		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(users.size())));
	}

	@DisplayName("Test to get user by id")
	@Test
	public void getUserByIdTest() throws Exception {

		long userId = 1l;
		when(userService.getUserById(userId)).thenReturn(user);

		ResultActions response = mockMvc
				.perform(get("/api/users/{id}", userId).contentType(MediaType.APPLICATION_JSON));

		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.firstName", is(user.getFirstName())));
	}

	@DisplayName("Test to create user")
	@Test
	public void createUserTest() throws JsonProcessingException, Exception {
		when(userService.createUser(user)).thenReturn(user);

		ResultActions response = mockMvc.perform(post("/api/users/user").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(user)));

		response.andDo(print()).andExpect(status().isCreated())
				.andExpect(jsonPath("$.firstName", is(user.getFirstName())));
	}

	@DisplayName("Test to update user")
	@Test
	public void updateUserTest() throws JsonProcessingException, Exception {

		user = User.builder().id(1).firstName("John").lastName("Doe").age(26).gender(Gender.M).email("john@mail.com")
				.phone("1231231231").city("city").type(UserType.Customer).active(Active.TRUE).build();

		when(userService.getUserById(user.getId())).thenReturn(user);

		User updatedUser = User.builder().id(1).firstName("Johny").lastName("Doe").age(26).gender(Gender.M)
				.email("john@mail.com").phone("1231231231").city("city").type(UserType.Customer).active(Active.TRUE)
				.build();

		when(userService.updateUser(user.getId(), user)).thenReturn(updatedUser);
		ResultActions response = mockMvc.perform(patch("/api/users/user/{id}", user.getId())
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(user)));

		response.andDo(print()).andExpect(status().isAccepted())
				.andExpect(jsonPath("$.firstName", is(updatedUser.getFirstName())));
	}

	@DisplayName("Test to delete user")
	@Test
	public void deleteUserById() throws Exception {

		when(userService.getUserById(1L)).thenReturn(user);
		willDoNothing().given(userService).deleteUserById(1L);

		ResultActions response = mockMvc.perform(delete("/api/users/user/{id}", 1L));

		response.andExpect(status().isNoContent()).andDo(print());
	}

}
