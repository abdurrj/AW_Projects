package com.example.BookStore;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookRepository {
    private List<Book> books;


    public BookRepository() {
        books = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 1; i <= 95; i++) {
            com.github.javafaker.Book fakebook = faker.book();
            books.add(new Book(200+i, fakebook.title(), fakebook.author(), 40 + i + 1.99, "Dec 31, " + (1910+i)));
        }
    }

    public List<Book> getPage(int page, int pageSize) {
        int from = Math.max(0,page*pageSize);
        int to = Math.min(books.size(),(page+1)*pageSize);

        return books.subList(from, to);
    }

    public int numberOfPages(int pageSize) {
        return (int)Math.ceil((double) books.size() / pageSize);
    }

    public Book getBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
