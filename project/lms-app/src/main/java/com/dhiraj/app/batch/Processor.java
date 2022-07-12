package com.dhiraj.app.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.entity.enums.Active;

@Component
public class Processor implements ItemProcessor<Book, Book> {

//	private static final map<String, String> =new HashMap<>();

	@Override
	public Book process(Book item) throws Exception {
		item.setActive(Active.TRUE);
		return item;
	}

}
