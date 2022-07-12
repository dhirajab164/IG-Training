package com.dhiraj.app.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DBWriter implements ItemWriter<Book> {

	private BookRepository bookRepository;

	public DBWriter(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public void write(List<? extends Book> items) throws Exception {
		System.out.println("Data saved for Books: " + items);
		log.info("Data saved for Books: {}", items);
		bookRepository.saveAll(items);
	}

}
