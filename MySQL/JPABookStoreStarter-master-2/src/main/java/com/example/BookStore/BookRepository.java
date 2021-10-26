package com.example.BookStore;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, Long>{

    Iterable<Book> findAllByOrderByAuthor();

    Iterable<Book> findAllByOrderByAuthorDesc();

}
