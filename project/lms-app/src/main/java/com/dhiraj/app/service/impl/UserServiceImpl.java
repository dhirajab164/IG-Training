package com.dhiraj.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dhiraj.app.entity.User;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.entity.enums.UserType;
import com.dhiraj.app.exception.BusinessException;
import com.dhiraj.app.repository.UserRepository;
import com.dhiraj.app.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User user) {

		User savedUser = userRepository.save(user);
		if (savedUser != null)
			return savedUser;
		else
			throw new BusinessException("Error creating new User.");
	}

	@Override
	public User getUserById(long id) {
		Optional<User> optional = userRepository.findById(id);
		User user = optional.isPresent() && optional.get().getActive() == Active.TRUE ? optional.get()
				: optional.orElseThrow(() -> new BusinessException("User Not Found."));
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		if (!users.isEmpty()) {
			return users.stream().filter(user -> user.getActive() == Active.TRUE).collect(Collectors.toList());
		} else {
			throw new BusinessException("Users not Found. List is Empty.");
		}
	}

	@Override
	public List<User> getAllUsersByType(UserType type) {
		List<User> users = userRepository.findUsersByType(type);
		if (!users.isEmpty()) {
			return users;
		} else {
			throw new BusinessException("User not Found for type: " + type + ". List is Empty.");
		}
	}

	@Override
	public User updateUser(long id, User user) {

		User toUpdate = getUserById(id);

		toUpdate.setFirstName(user.getFirstName());
		toUpdate.setLastName(user.getLastName());
		toUpdate.setAge(user.getAge());
		toUpdate.setGender(user.getGender());
		toUpdate.setEmail(user.getEmail());
		toUpdate.setPhone(user.getPhone());
		toUpdate.setCity(user.getCity());
		toUpdate.setType(user.getType());
		toUpdate.setActive(user.getActive());

		return toUpdate;
	}

	@Override
	public void deleteUserById(long id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			optional.get().setActive(Active.FALSE);
			updateUser(id, optional.get());
		} else
			optional.orElseThrow(() -> new BusinessException("User Not Found."));
	}

}
