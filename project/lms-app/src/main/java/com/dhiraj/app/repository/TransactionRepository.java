package com.dhiraj.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhiraj.app.entity.Transaction;
import com.dhiraj.app.entity.enums.TransactionStatus;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findTransactionsByStatus(TransactionStatus status);

}
