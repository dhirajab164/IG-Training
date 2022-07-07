package com.dhiraj.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhiraj.app.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findBooksByAuthor(String author);

	List<Book> findBooksByPublication(String publication);

	List<Book> findBooksByActive(int ordinal);

	List<Book> findBookByTitle(String title);

}
