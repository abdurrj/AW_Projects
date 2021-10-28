package com.example.BookStore;

import org.springframework.data.repository.CrudRepository;



public interface BookRepository extends CrudRepository<Book, Long>{

    Iterable<Book> findAllByOrderByAuthor();

    Iterable<Book> findAllByOrderByAuthorDesc();

}
