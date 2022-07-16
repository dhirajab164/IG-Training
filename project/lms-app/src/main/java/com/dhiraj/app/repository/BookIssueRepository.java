package com.dhiraj.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhiraj.app.entity.BookIssue;
import com.dhiraj.app.entity.enums.BookIssueStatus;

public interface BookIssueRepository extends JpaRepository<BookIssue, Long> {

//	List<BookIssue> findBookIssueByBookIssueStatus(BookIssueStatus status);
	

}
