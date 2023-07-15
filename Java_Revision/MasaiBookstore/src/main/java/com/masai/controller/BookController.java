package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.masai.exception.AuthorizationException;
import com.masai.exception.BookException;
import com.masai.exception.LoginException;
import com.masai.model.Book;
import com.masai.service.BookService;

import jakarta.validation.Valid;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/books/{Key}")
	public ResponseEntity<Book> createBook(@Valid @PathVariable("Key") String key, @RequestBody Book book)
			throws LoginException, AuthorizationException {

		Book b = bookService.createNewBook(key, book);

		return new ResponseEntity<>(b, HttpStatus.CREATED);
	}

	@GetMapping("/books/{ISBN}")
	public ResponseEntity<Book> findByISBNId(@Valid @PathVariable("ISBN") Integer ISBN) throws BookException {

		Book b = bookService.findByISBNId(ISBN);

		return new ResponseEntity<>(b, HttpStatus.OK);
	}

	@GetMapping("/books/{title}/{author}")
	public ResponseEntity<List<Book>> findByTitleAndAuthor(@Valid @PathVariable("title") String title,
			@PathVariable("author") String author) throws BookException {
		List<Book> b = bookService.findByTitleAndAuthor(title, author);
		return new ResponseEntity<>(b, HttpStatus.OK);
	}

	@GetMapping("/books/available")
	public ResponseEntity<List<Book>> findAllAvailableBooks() throws BookException {
		List<Book> b = bookService.findAllAvailableBooks();
		return new ResponseEntity<>(b, HttpStatus.OK);
	}

	@PutMapping("/books/{Key}")
	public ResponseEntity<Book> updateExistingBook(@Valid @PathVariable("Key") String key, @RequestBody Book book)
			throws LoginException, AuthorizationException, BookException {

		Book b = bookService.updateExistingBook(key, book);

		return new ResponseEntity<>(b, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/books/{Key}/{ISBN}")
	public ResponseEntity<Book> deleteBookByIsbn(@Valid @PathVariable("Key") String key,
			@PathVariable("ISBN") Integer isbn) throws LoginException, AuthorizationException, BookException {

		Book b = bookService.deleteBookByIsbn(key, isbn);

		return new ResponseEntity<>(b, HttpStatus.ACCEPTED);
	}

}
