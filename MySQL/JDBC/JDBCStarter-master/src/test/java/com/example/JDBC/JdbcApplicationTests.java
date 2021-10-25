package com.example.JDBC;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JdbcApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testBooksCount() {
		int count = bookRepository.getBooksCount();
		assertEquals(3, count, "Books count should be 3");
	}

	@Test
	public void testGetBooks() {
		List<Book> books = bookRepository.getBooks();
		assertEquals(3, books.size(), "There should be 3 books in the list");
	}

	@Test
	public void testGetBookWithId() {
		Book book = bookRepository.getBook(2);
		assertEquals("Douglas Adams", book.getAuthor(), "Book with id=1 should be Douglas Adams");
	}

	@Test
	public void testGetBooksByAuthor() {
		List<Book> books = bookRepository.getBooksByAuthor("Homer");
		assertEquals("The Iliad", books.get(0).getTitle(), "Book with author Homer should be The Iliad");

		int count = bookRepository.getBooksCount();
		List<Book> books2 = bookRepository.getBooksByAuthor("Homer' or author not like 'Homer");
		assertEquals(count, books2.size(), "SQL Injection attempt should return all books in the table");
	}

	@Test
	public void testGetBooksByAuthorSafe() {
		List<Book> books = bookRepository.getBooksByAuthorSafe("Homer");
		assertEquals("The Iliad", books.get(0).getTitle(),"Book with author Homer should be The Iliad");

		List<Book> books2 = bookRepository.getBooksByAuthorSafe("Homer' or author not like 'Homer");
		assertEquals(0, books2.size(), "SQL Injection attempt should return emtpy list");
	}

	@Test
	public void testGetBooksByCustomer() {
		List<Book> books = bookRepository.getBooksByCustomer("Donald");
		assertEquals("Douglas Adams", books.get(0).getAuthor(), "Book purchased by customer Donald should be Douglas Adams");
	}


	@Test
	public void testAddBook() {
		int count = bookRepository.getBooksCount();
		bookRepository.addBook(new Book(null, "New Book Title", "Test Class", 1));
		List<Book> books = bookRepository.getBooks();

		assertEquals((count+1), books.size(), "Books count is increased with 1");

		Book lastBook = books.get(books.size()-1);

		assertEquals("Test Class", lastBook.getAuthor(), "Last book is the book created by this method");
	}

	@Test
	public void testGetBooksMeta() {
		int count = bookRepository.getBooksCount();
		List<Book> books = bookRepository.getBooksMeta();
		assertEquals(count, books.size(), "There should be 3 books in the list");
	}

}

