package com.dhiraj.batch.app.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dhiraj.batch.app.model.User;
import com.dhiraj.batch.app.repository.UserRepository;

@Component
public class DBWriter implements ItemWriter<User> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void write(List<? extends User> users) throws Exception {

		System.out.println("Data Saved for Users: " + users);
		userRepository.saveAll(users);
	}

}
