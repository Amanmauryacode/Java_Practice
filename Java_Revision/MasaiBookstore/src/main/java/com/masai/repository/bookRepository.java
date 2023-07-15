package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.model.Book;

@Repository
public interface bookRepository extends JpaRepository<Book, Integer> {

	public Book findByIsbn(Integer ISBN);
	
	@Query("select b from Book b where b.title = :title and b.author =:author")
	public List<Book> findByTitleAndAuthor(@Param("title") String title,@Param("author") String author);
	
	@Query("select b from Book b where b.status = true")
	public List<Book> findAllAvailableBooks();
}
