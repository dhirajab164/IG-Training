package com.dhiraj.app.service;

import java.util.List;

import com.dhiraj.app.entity.User;
import com.dhiraj.app.entity.enums.UserType;

public interface IUserService {

	public User createUser(User user);

	public User getUserById(long id);

	public List<User> getAllUsers();

	public List<User> getAllUsersByType(UserType type);

	public User updateUser(long id, User User);

	public void deleteUserById(long id);

}
