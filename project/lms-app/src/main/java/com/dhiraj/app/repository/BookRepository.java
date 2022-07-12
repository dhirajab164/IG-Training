package com.dhiraj.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhiraj.app.entity.Book;
import com.dhiraj.app.entity.enums.Active;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findBooksByAuthor(String author);

	List<Book> findBooksByPublication(String publication);

	List<Book> findBooksByActive(Active active);

	List<Book> findBookByTitle(String title);

}
