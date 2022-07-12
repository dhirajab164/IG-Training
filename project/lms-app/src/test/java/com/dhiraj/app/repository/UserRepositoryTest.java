package com.dhiraj.app.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.dhiraj.app.entity.User;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.entity.enums.Gender;
import com.dhiraj.app.entity.enums.UserType;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;

	private User user;

	@BeforeEach
	public void init() {
		user = User.builder().firstName("John").lastName("Doe").age(26).gender(Gender.M).email("john@mail.com")
				.phone("1231231231").city("city").type(UserType.C).active(Active.TRUE).build();
		userRepository.save(user);
	}

	@DisplayName("Test for user by id")
	@Test
	public void findByIdTest() {
		User userById = userRepository.findById(user.getId()).get();

		assertThat(userById.getFirstName()).isEqualTo(user.getFirstName());
	}

	@DisplayName("Test for get all users")
	@Test
	public void findAllTest() {
		List<User> users = userRepository.findAll();

		assertThat(users).isNotNull();
		assertThat(users.size()).isEqualTo(1);
	}

	@DisplayName("Test for user by type")
	@Test
	public void findUserByTypeTest() {
		List<User> userByTitle = userRepository.findUsersByType(UserType.C);
		for (User user : userByTitle) {
			assertThat(user.getType()).isEqualTo(UserType.C);
		}
	}

	@DisplayName("Test for user save")
	@Test
	public void userSaveTest() {

		User savedUser = userRepository.save(user);
		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getId()).isGreaterThan(0);
	}

	@DisplayName("Test for user update")
	@Test
	public void userUpdateTest() {

		User savedUser = userRepository.findById(user.getId()).get();
		String firstName = "John";
		savedUser.setFirstName(firstName);

		assertEquals(firstName, savedUser.getFirstName());
	}
}
