package com.dhiraj.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dhiraj.app.entity.Transaction;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.exception.BusinessException;
import com.dhiraj.app.repository.TransactionRepository;
import com.dhiraj.app.service.ITransactionService;

@Service
public class TransactionServiceImpl implements ITransactionService {

	private TransactionRepository transactionRepository;

	public TransactionServiceImpl(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository = transactionRepository;
	}

	@Override
	public Transaction createTransaction(Transaction transaction) {

		Transaction savedTransaction = transactionRepository.save(transaction);
		if (savedTransaction != null)
			return savedTransaction;
		else
			throw new BusinessException("Error creating new Transaction.");
	}

	@Override
	public Transaction getTransactionById(long id) {
		Optional<Transaction> optional = transactionRepository.findById(id);
		Transaction transaction = optional.isPresent() && optional.get().getActive() == Active.TRUE ? optional.get()
				: optional.orElseThrow(() -> new BusinessException("Transaction Not Found."));
		return transaction;
	}

	@Override
	public List<Transaction> getAllTransactions() {
		List<Transaction> transactions = transactionRepository.findAll();
		if (!transactions.isEmpty()) {
			return transactions.stream().filter(transaction -> transaction.getActive() == Active.TRUE)
					.collect(Collectors.toList());
		} else {
			throw new BusinessException("Transactions not Found. List is Empty.");
		}
	}

	@Override
	public List<Transaction> getAllTransactionsByStatus(int status) {
		List<Transaction> transactions = transactionRepository.findTransactionsByStatus(status);
		if (!transactions.isEmpty()) {
			return transactions;
		} else {
			throw new BusinessException("Transaction not Found for status: " + status + ". List is Empty.");
		}
	}

	@Override
	public Transaction updateTransaction(long id, Transaction transaction) {
		Transaction toUpdate = getTransactionById(id);
		toUpdate.setBook(transaction.getBook());
		toUpdate.setIssuedTo(transaction.getIssuedTo());
		toUpdate.setIssuedBy(transaction.getIssuedBy());
		toUpdate.setActive(transaction.getActive());
		toUpdate.setStatus(transaction.getStatus());
		toUpdate.setRemark(transaction.getRemark());
		toUpdate.setIssuedOn(transaction.getIssuedOn());
		toUpdate.setToBeReturnedOn(transaction.getToBeReturnedOn());
		return toUpdate;
	}

	@Override
	public void deleteTransactionById(long id) {
		Optional<Transaction> optional = transactionRepository.findById(id);
		if (optional.isPresent()) {
			optional.get().setActive(Active.FALSE);
			updateTransaction(id, optional.get());
		} else
			optional.orElseThrow(() -> new BusinessException("Transaction Not Found."));
	}

}
