package com.dhiraj.app.service;

import java.util.List;

import com.dhiraj.app.entity.BookIssue;
import com.dhiraj.app.entity.enums.BookIssueStatus;

public interface IBookIssueService {
	public BookIssue createBookIssue(BookIssue bookIssue);

	public BookIssue getBookIssueById(long id);

	public List<BookIssue> getAllBookIssues();

	public List<BookIssue> getAllBookIssuesByStatus(BookIssueStatus status);

	public BookIssue updateBookIssue(BookIssue bookIssue);
	
	public BookIssue patchBookIssue(long id, BookIssue bookIssue);

	public void deleteBookIssueById(long id);
}
