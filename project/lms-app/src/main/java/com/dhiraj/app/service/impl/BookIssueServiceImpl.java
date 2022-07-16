package com.dhiraj.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhiraj.app.entity.BookIssue;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.entity.enums.BookIssueStatus;
import com.dhiraj.app.exception.BusinessException;
import com.dhiraj.app.repository.BookIssueRepository;
import com.dhiraj.app.service.IBookIssueService;

@Transactional
@Service
public class BookIssueServiceImpl implements IBookIssueService {

	private BookIssueRepository bookIssueRepository;

	public BookIssueServiceImpl(BookIssueRepository bookIssueRepository) {
		super();
		this.bookIssueRepository = bookIssueRepository;
	}

	@Override
	public BookIssue createBookIssue(BookIssue bookIssue) {

		BookIssue savedBookIssue = bookIssueRepository.save(bookIssue);
		if (savedBookIssue != null)
			return savedBookIssue;
		else
			throw new BusinessException("Error creating new BookIssue.");
	}

	@Override
	public BookIssue getBookIssueById(long id) {
		Optional<BookIssue> optional = bookIssueRepository.findById(id);
		BookIssue bookIssue = optional.isPresent() && optional.get().getActive() == Active.TRUE ? optional.get()
				: optional.orElseThrow(() -> new BusinessException("BookIssue Not Found."));
		return bookIssue;
	}

	@Override
	public List<BookIssue> getAllBookIssues() {
		List<BookIssue> bookIssues = bookIssueRepository.findAll();
		if (!bookIssues.isEmpty()) {
			return bookIssues.stream().filter(issue -> issue.getActive() == Active.TRUE)
					.collect(Collectors.toList());
		} else {
			throw new BusinessException("BookIssues not Found. List is Empty.");
		}
	}

	@Override
	public List<BookIssue> getAllBookIssuesByStatus(BookIssueStatus status) {
		List<BookIssue> bookIssues = bookIssueRepository.findBookIssueByBookIssueStatus(status);
		if (!bookIssues.isEmpty()) {
			return bookIssues;
		} else {
			throw new BusinessException("BookIssue not Found for status: " + status + ". List is Empty.");
		}
	}

	@Override
	public BookIssue updateBookIssue(BookIssue bookIssue) {
		BookIssue toUpdate = getBookIssueById(bookIssue.getId());
		toUpdate.setBook(bookIssue.getBook());
		toUpdate.setIssuedTo(bookIssue.getIssuedTo());
		toUpdate.setIssuedBy(bookIssue.getIssuedBy());
		toUpdate.setActive(bookIssue.getActive());
		toUpdate.setStatus(bookIssue.getStatus());
		toUpdate.setRemark(bookIssue.getRemark());
		toUpdate.setIssuedOn(bookIssue.getIssuedOn());
		toUpdate.setToBeReturnedOn(bookIssue.getToBeReturnedOn());
		return toUpdate;
	}

	@Override
	public void deleteBookIssueById(long id) {
		Optional<BookIssue> optional = bookIssueRepository.findById(id);
		if (optional.isPresent()) {
			optional.get().setActive(Active.FALSE);
			patchBookIssue(id, optional.get());
		} else
			optional.orElseThrow(() -> new BusinessException("BookIssue Not Found."));
	}

	@Override
	public BookIssue patchBookIssue(long id, BookIssue bookIssue) {
		BookIssue toUpdate = getBookIssueById(bookIssue.getId());
		toUpdate.setBook(bookIssue.getBook());
		toUpdate.setIssuedTo(bookIssue.getIssuedTo());
		toUpdate.setIssuedBy(bookIssue.getIssuedBy());
		toUpdate.setActive(bookIssue.getActive());
		toUpdate.setStatus(bookIssue.getStatus());
		toUpdate.setRemark(bookIssue.getRemark());
		toUpdate.setIssuedOn(bookIssue.getIssuedOn());
		toUpdate.setToBeReturnedOn(bookIssue.getToBeReturnedOn());
		return toUpdate;
	}

}
