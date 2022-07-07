package com.dhiraj.app;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.entity.Transaction;
import com.dhiraj.app.entity.User;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.entity.enums.TransactionStatus;
import com.dhiraj.app.repository.BookRepository;
import com.dhiraj.app.repository.TransactionRepository;
import com.dhiraj.app.repository.UserRepository;

@SpringBootApplication
public class LmsAppApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private TransactionRepository transactionRepository;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(LmsAppApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("start");

		List<User> users = userRepository.findAll();
		users.forEach(System.out::println);

		List<Book> books = bookRepository.findAll();
		books.forEach(System.out::println);

		User user1 = userRepository.findById(1L).get();
		System.out.println(user1);

		User lib1 = userRepository.findById(2L).get();
		System.out.println(lib1);

		Book book1 = bookRepository.findById(1L).get();
		System.out.println(book1);

		Transaction tr1 = new Transaction(book1, user1, lib1, Active.TRUE, TransactionStatus.PENDING, "NA",
				LocalDate.now(), LocalDate.now().plusDays(3), user1, user1);
		transactionRepository.save(tr1);

		List<Transaction> trs = transactionRepository.findAll();
		trs.forEach(System.out::println);

		System.out.println("end");
	}

}
