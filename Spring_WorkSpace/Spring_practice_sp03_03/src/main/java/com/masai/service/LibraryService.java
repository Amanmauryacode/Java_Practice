package com.masai.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Book;
import com.masai.model.Librarian;
import com.masai.model.Member;
@Service
public class LibraryService {
	// Hint: Use setter injection to inject bookMap, librarianList, and memberList
	@Autowired
	private Map<Librarian, List<Book>> bookMap; // inject 3 entries with valid details
	@Autowired
	private List<Librarian> librarianList; // inject a list of 5 Librarian objects
	@Autowired
	private List<Member> memberList; // inject a list of 7 Member objects

	public void printBookMap() {
		// print all the librarians and their associated book details from the bookMap

		for (Map.Entry<Librarian, List<Book>> bookmap : bookMap.entrySet()) {
			System.out.println("-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println(bookmap.getKey());
			bookmap.getValue().forEach(System.out::println);
			System.out.println("-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

		}
	}

	public void printLibrarianList() {
		// sort the list of librarians according to the decreasing order of the
		// noOfBooksIssued
		// if noOfBooksIssued are the same, then sort by age
		// print all the sorted Librarian details

		librarianList.sort((a, b) -> {

			if (a.getNoOfBooksIssued() == b.getNoOfBooksIssued()) {
				return a.getAge() - b.getAge();
			}
			return b.getNoOfBooksIssued() - a.getNoOfBooksIssued();

		});
		librarianList.forEach(System.out::println);
	}

	public void printMemberList() {
		// sort the list of members according to the decreasing order of the
		// noOfBooksBorrowed
		// if noOfBooksBorrowed are the same, then sort by age
		// print all the sorted Member details
		memberList.sort((a, b) -> {

			if (a.getNoOfBooksBorrowed() == b.getNoOfBooksBorrowed()) {
				return a.getAge() - b.getAge();
			}
			return b.getNoOfBooksBorrowed() - a.getNoOfBooksBorrowed();

		});
		memberList.forEach(System.out::println);
	}

	public void issueBook(int librarianId, int memberId, int bookId) {
		// Find the Librarian, Member, and Book objects by their respective IDs
		// Check if the book is available and the member can borrow books (based on a
		// borrowing limit)
		// Update the book's availability, the librarian's noOfBooksIssued, and the
		// member's noOfBooksBorrowed
		// Add the issued book to the bookMap
		Member member = null;
		Librarian librarian = null;
		Book book = null;
		List<Book> bookList = null;

		for (Librarian lib : librarianList) {
			if (lib.getId() == librarianId) {
				librarian = lib;
				break;
			}
		}

		for (Member m : memberList) {
			if (m.getId() == memberId) {
				member = m;
				break;
			}
		}

		for (Map.Entry<Librarian, List<Book>> bookmap : bookMap.entrySet()) {
			if (bookmap.getKey().getId() == librarianId) {
				bookList = bookmap.getValue();

				for (Book b : bookmap.getValue()) {
					if (b.getId() == bookId) {
						book = b;
						break;
					}
				}
				break;
			}
		}

		if (librarian == null || member == null || book == null || bookList == null) {
			throw new RuntimeException("All Values Not Found!");
		}

		if (book.isAvailable()) {
			if (member.getNoOfBooksBorrowed() >= 4) {
				book.setAvailable(false);
				librarian.setNoOfBooksIssued(librarian.getNoOfBooksIssued() + 1);
				member.setNoOfBooksBorrowed(member.getNoOfBooksBorrowed() + 1);
				bookList.add(book);
				bookMap.put(librarian, bookList);
				System.out.println("Book Issued...");

			} else
				throw new RuntimeException("Member Cannot Borrow More Than 5 Books");
		} else
			throw new RuntimeException("Book Is Not Available!");

	}

	public void returnBook(int librarianId, int memberId, int bookId) {
		// Find the Librarian, Member, and Book objects by their respective IDs
		// Check if the book is currently borrowed by the member
		// Update the book's availability, the librarian's noOfBooksIssued, and the
		// member's noOfBooksBorrowed
		// Remove the returned book from the bookMap
		Member member = null;
		Librarian librarian = null;
		Book book = null;
		List<Book> bookList = null;

		for (Librarian lib : librarianList) {
			if (lib.getId() == librarianId) {
				librarian = lib;
				break;
			}
		}

		for (Member m : memberList) {
			if (m.getId() == memberId) {
				member = m;
				break;
			}
		}

		for (Map.Entry<Librarian, List<Book>> bookmap : bookMap.entrySet()) {
			if (bookmap.getKey().getId() == librarianId) {
				bookList = bookmap.getValue();

				for (Book b : bookmap.getValue()) {
					if (b.getId() == bookId) {
						book = b;
						break;
					}
				}
				break;
			}
		}

		if (librarian == null || member == null || book == null || bookList == null) {
			throw new RuntimeException("All Values Not Found!");
		}

		if (!book.isAvailable()) {
			if (member.getNoOfBooksBorrowed() > 0) {
				book.setAvailable(false);
				librarian.setNoOfBooksIssued(librarian.getNoOfBooksIssued() - 1);
				member.setNoOfBooksBorrowed(member.getNoOfBooksBorrowed() - 1);
				bookList.remove(book);
				bookMap.put(librarian, bookList);
				System.out.println("Book Removed...");

			} else
				throw new RuntimeException("Member Cannot Borrow Any Books");
		} else
			throw new RuntimeException("Book Is Not Borrowed By Any Member!");
	}
}
