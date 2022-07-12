package com.dhiraj.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.app.entity.User;
import com.dhiraj.app.exception.ErrorMessage;
import com.dhiraj.app.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private IUserService userService;

	public UserController(IUserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getBookById(@PathVariable long id) {
		if (id != 0) {
			User user = userService.getUserById(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Incorrect Id sent.").description("Id should be greater than zero").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/user")
	public ResponseEntity<?> createBook(@RequestBody User user) {
		if (user != null) {
			User createdUser = userService.createUser(user);
			return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
		} else {
			ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), LocalDate.now(),
					"User is Empty.", "Empty Object sent to save.");
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@PatchMapping("/user/{id}")
	public ResponseEntity<?> updateBook(@PathVariable long id, @RequestBody User user) {
		if (id <= 0) {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Incorrect Id sent.").description("Id should be greater than zero").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		} else if (userService.getUserById(id) != null && user != null) {
			User updateUser = userService.updateUser(id, user);
			return new ResponseEntity<User>(updateUser, HttpStatus.ACCEPTED);
		} else {
			ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), LocalDate.now(),
					"User is Empty.", "Empty Object sent to save.");
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteBookById(long id) {
		if (id <= 0) {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.BAD_REQUEST.value())
					.message("Incorrect Id sent.").description("Id should be greater than zero").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		} else if (userService.getUserById(id) != null) {
			userService.deleteUserById(id);
			return new ResponseEntity<String>("User Deleted with id: " + id, HttpStatus.NO_CONTENT);
		} else {
			ErrorMessage errorMessage = ErrorMessage.builder().statusCode(HttpStatus.NOT_FOUND.value())
					.message("User not Found.").description("User with ID: " + id + " not Available.").build();
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

}
