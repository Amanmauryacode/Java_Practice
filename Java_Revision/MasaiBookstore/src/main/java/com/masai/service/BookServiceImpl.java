package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AuthorizationException;
import com.masai.exception.BookException;
import com.masai.exception.LoginException;
import com.masai.model.Book;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.repository.SessionDao;
import com.masai.repository.bookRepository;
import com.masai.repository.userRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private SessionDao sDao;
	@Autowired
	private bookRepository bookRepo;
	@Autowired
	private userRepository userRepo;

	@Override
	public Book createNewBook(String uuid, Book book) throws LoginException, AuthorizationException {

		CurrentUserSession cus = sDao.findByUuid(uuid);

		if (cus == null) {
			throw new LoginException("User not login into our System");
		}

		Optional<User> u = userRepo.findById(cus.getUserId());

		if (u.isEmpty()) {
			throw new AuthorizationException("User not found ");
		} else {
			if (u.get().getRole().equals("ADMIN")) {
				Book b = bookRepo.save(book);
				return b;
			} else {
				throw new AuthorizationException("User not Authorized to perform this operation ");
			}
		}

	}

	@Override
	public Book findByISBNId(Integer ISBN) throws BookException {

		Book book = bookRepo.findByIsbn(ISBN);

		if (book == null)
			throw new BookException("No book found with ISBN : " + ISBN);
		return book;
	}

	@Override
	public List<Book> findByTitleAndAuthor(String title, String author) throws BookException {
		List<Book> books = bookRepo.findByTitleAndAuthor(title, author);

		if (books.isEmpty())
			throw new BookException("No book found with title : " + title + " and author : " + author);
		return books;
	}

	@Override
	public List<Book> findAllAvailableBooks() throws BookException {
		List<Book> books = bookRepo.findAllAvailableBooks();
		if (books.isEmpty())
			throw new BookException("No Available book found in record ");
		return books;
	}

	@Override
	public Book updateExistingBook(String uuid,Book book) throws LoginException, AuthorizationException, BookException {
		CurrentUserSession cus = sDao.findByUuid(uuid);

		if (cus == null) {
			throw new LoginException("User not login into our System");
		}

		Optional<User> u = userRepo.findById(cus.getUserId());

		if (u.isEmpty()) {
			throw new AuthorizationException("User not found ");
		} else {
			if (u.get().getRole().equals("ADMIN")) {

				Optional<Book> opt = bookRepo.findById(book.getId());

				if (opt.isEmpty())
					throw new BookException("No book found in record with id : " + book.getId());
				Book b = bookRepo.save(book);
				return b;
			} else {
				throw new AuthorizationException("User not Authorized to perform this operation ");
			}
		}
	}

	@Override
	public Book deleteBookByIsbn(String uuid,Integer isbn) throws LoginException, AuthorizationException, BookException {
		CurrentUserSession cus = sDao.findByUuid(uuid);

		if (cus == null) {
			throw new LoginException("User not login into our System");
		}

		Optional<User> u = userRepo.findById(cus.getUserId());

		if (u.isEmpty()) {
			throw new AuthorizationException("User not found ");
		} else {
			if (u.get().getRole().equals("ADMIN")) {

				Book book = bookRepo.findByIsbn(isbn);

				if (book == null)
					throw new BookException("No book found with ISBN : " + isbn);
				bookRepo.delete(book);
				return book;
				
			} else {
				throw new AuthorizationException("User not Authorized to perform this operation ");
			}
		}
	}

}
