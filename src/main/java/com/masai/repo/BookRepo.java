package com.masai.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

	public List<Book> findByTitle(String title);
	
	
	@Query("select b from Book as b where b.author= ?1")
	public List<Book> getBookByAuthor(String author);
}
