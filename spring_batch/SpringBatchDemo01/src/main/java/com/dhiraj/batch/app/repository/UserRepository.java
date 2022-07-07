package com.dhiraj.batch.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhiraj.batch.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
