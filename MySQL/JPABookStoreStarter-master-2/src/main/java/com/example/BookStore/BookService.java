package com.example.BookStore;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final List<Book> books;

    public BookService() {
        books = new ArrayList<>();

        for (int i = 1; i <= 95; i++) {
            books.add(new Book((long) (200 + i), "Book Title " + i, "Author name " + i, 40 + i));
        }
    }

    public Book getBook(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}
