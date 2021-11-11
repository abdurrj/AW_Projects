package no.academy.bookservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book")
    public List<Book> getBook(){
        return (List<Book>)bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable long id){
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book postBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @PutMapping("/book/{id}")
    public Book put(@PathVariable Long id, @RequestBody Book book){
        return bookRepository.save(book);
    }

    @DeleteMapping("/book/{id}")
    public void delete(@PathVariable Long id){
        bookRepository.deleteById(id);
    }
}
