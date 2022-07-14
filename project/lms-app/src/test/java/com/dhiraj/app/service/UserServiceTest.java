package com.dhiraj.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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

import com.dhiraj.app.entity.User;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.entity.enums.Gender;
import com.dhiraj.app.entity.enums.UserType;
import com.dhiraj.app.repository.UserRepository;
import com.dhiraj.app.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	private User user;

	@BeforeEach
	private void init() {
		user = User.builder().firstName("John").lastName("Doe").age(26).gender(Gender.M).email("john@mail.com")
				.phone("1231231231").city("city").type(UserType.Customer).active(Active.TRUE).build();
	}

	@DisplayName("Test get all users ")
	@Test
	public void getAllUsersTest() {
		List<User> users = Arrays.asList(user);

		when(userRepository.findAll()).thenReturn(users);

		List<User> list = userService.getAllUsers();

		assertEquals(1, list.size());
	}

	@DisplayName("Test get user by id")
	@Test
	public void getUserByIdTest() {
		when(userRepository.findById(1l)).thenReturn(Optional.of(user));

		User usr = userService.getUserById(1l);

		assertEquals("John", usr.getFirstName());
	}

	@DisplayName("Test delete user by id")
	@Test
	public void deleteUserByIdTest() {

		when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

		userService.deleteUserById(user.getId());
		assertEquals(Active.FALSE, user.getActive());
	}

	@DisplayName("Test create user")
	@Test
	public void createUserTest() {
		User usr = User.builder().id(1).firstName("John").lastName("Doe").age(26).gender(Gender.M)
				.email("john@mail.com").phone("1231231231").city("city").type(UserType.Customer).active(Active.TRUE).build();
		when(userRepository.save(user)).thenReturn(usr);

		User newUser = userService.createUser(user);
		assertEquals(1, newUser.getId());
	}

	@DisplayName("Test to user update")
	@Test
	public void updateUserTest() {
		userRepository.save(user);
		String firstName = "John";

		when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		user.setFirstName(firstName);

		User updatedUser = userService.updateUser(user.getId(), user);
		assertThat(updatedUser.getFirstName()).isEqualTo(firstName);

	}

}
