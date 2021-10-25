package com.example.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
        return bookRepository.getBooksByAuthor(author);
    }

    @GetMapping("/booksByAuthorSafe/{author}")
    public List<Book> bookSafe(@PathVariable String author) {
        return bookRepository.getBooksByAuthorSafe(author);
    }

/*
    @GetMapping("/addBook/{title}/{author}/{price}")
    public String addBookMapping(@PathVariable String title, @PathVariable String author, @PathVariable int price){
        bookRepository.addBook(new Book(null, title, author, price));
        return "book added";
    }
*/

    @GetMapping("/addBook")
    public String addBook(){
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBookPostMapping(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam int price
    ){
        bookRepository.addBook(new Book(null, title, author, price));
        return "addBookReturn";
    }


}
