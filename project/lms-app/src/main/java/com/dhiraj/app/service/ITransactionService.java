package com.dhiraj.app.service;

import java.util.List;

import com.dhiraj.app.entity.Transaction;
import com.dhiraj.app.entity.enums.TransactionStatus;

public interface ITransactionService {
	public Transaction createTransaction(Transaction transaction);

	public Transaction getTransactionById(long id);

	public List<Transaction> getAllTransactions();

	public List<Transaction> getAllTransactionsByStatus(TransactionStatus status);

	public Transaction updateTransaction(long id, Transaction transaction);

	public void deleteTransactionById(long id);
}
