package com.masai.service;

import java.util.List;

import com.masai.exception.AuthorizationException;
import com.masai.exception.BookException;
import com.masai.exception.LoginException;
import com.masai.model.Book;

public interface BookService {

	public Book createNewBook(String uuid,Book book)throws LoginException,AuthorizationException;
	
	public Book findByISBNId(Integer ISBN)throws BookException;
	
	public List<Book> findByTitleAndAuthor(String title,String author)throws BookException;
	
	public List<Book> findAllAvailableBooks()throws BookException;
	
	public Book updateExistingBook(String uuid,Book book)throws LoginException,AuthorizationException,BookException;
	
	public Book deleteBookByIsbn(String uuid,Integer isbn)throws LoginException,AuthorizationException,BookException;
}
