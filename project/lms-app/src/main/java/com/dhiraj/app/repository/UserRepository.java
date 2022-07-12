package com.dhiraj.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhiraj.app.entity.User;
import com.dhiraj.app.entity.enums.UserType;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findUsersByUserType(int type);

}
