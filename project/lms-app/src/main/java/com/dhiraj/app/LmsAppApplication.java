package com.dhiraj.app;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.entity.User;
import com.dhiraj.app.entity.enums.Active;
import com.dhiraj.app.repository.BookRepository;
import com.dhiraj.app.repository.TransactionRepository;
import com.dhiraj.app.repository.UserRepository;
import com.dhiraj.app.service.IBookService;
import com.dhiraj.app.service.impl.BookServiceImpl;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LmsAppApplication implements CommandLineRunner {

//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private IBookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(LmsAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Application started on." + LocalDate.now());
		System.out.println("start");

//		User lib1 = userRepository.findById(2L).get();
//		System.out.println(lib1);
//
//		Book book = Book.builder().title("Title").author("Author").publication("Publication").pages(120).price(150.0)
//				.copies(100).active(Active.TRUE).createdBy(lib1).createdOn(LocalDate.now()).updatedBy(lib1)
//				.updatedOn(LocalDate.now()).build();
//
//		// create
//		Book createBook = bookService.createBook(book);
//		System.out.println(createBook);
//
//		// update
//		Book toUpdate = Book.builder().title("Title Updated").author("Author Updated")
//				.publication("Publication Updated").pages(120).price(150.0).copies(100).active(Active.TRUE)
//				.createdBy(lib1).createdOn(LocalDate.now()).updatedBy(lib1).updatedOn(LocalDate.now()).build();
//		Book updateBook = bookService.updateBook(1, toUpdate);
//		System.out.println("Updated Book: " + updateBook);
//
//		// delete
//		bookService.deleteBookByid(1l);
//		System.out.println("bookService.getBookById(1l): " + bookService.getBookById(1l));

		System.out.println("end");
	}

}
