package com.example.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/countbooks")
    public int countBooks(){
        return bookRepository.getBooksCount();
    }

    @GetMapping("/getbooks")
    public List<Book> getBooks(){
        return bookRepository.getBooks();
    }

    @GetMapping("/booksByAuthor/{author}")
    public List<Book> book(@PathVariable String author) {
        return bookRepository.getBooksByAuthor2(author);
    }

}
