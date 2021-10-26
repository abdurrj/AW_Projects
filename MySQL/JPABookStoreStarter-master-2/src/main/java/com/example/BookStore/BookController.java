package com.example.BookStore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private static final int PAGE_SIZE = 10;

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String books(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {

        List<Book> books = getPage(page-1, PAGE_SIZE);
        int pageCount = numberOfPages(PAGE_SIZE);
        int[] pages = toArray(pageCount);

        model.addAttribute("books", books);
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("showPrev", page > 1);
        model.addAttribute("showNext", page < pageCount);

        return "books";
    }

    @GetMapping("/book/{page}/{id}")
    public String book(Model model, @PathVariable Integer page, @PathVariable Long id) {
        Book book = repository.findById(id).get();
        model.addAttribute("page", page);
        model.addAttribute("book", book);

        return "book";
    }


    private int[] toArray(int num) {
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = i+1;
        }
        return result;
    }

    private List<Book> getPage(int page, int pageSize) {
        List<Book> books = new ArrayList<>();
        Iterable<Book> itbook = repository.findAll();
        itbook.forEach(books::add);

        int from = Math.max(0,page*pageSize);
        int to = Math.min(books.size(),(page+1)*pageSize);

        return books.subList(from, to);
    }

    private int numberOfPages(int pageSize) {
        List<Book> books = new ArrayList<>();
        Iterable<Book> itbook = repository.findAll();
        itbook.forEach(books::add);
        return (int)Math.ceil((double) books.size() / pageSize);
    }

    @GetMapping("/sortedBooks")
    public String sortBooks(Model model){
        List<Book> books = new ArrayList<>();
        Iterable<Book> itbook = repository.findAllByOrderByAuthor();
        itbook.forEach(books::add);
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/add")
    public String addBookPage(@ModelAttribute Book book){
        return "add";
    }

    @PostMapping("/addBook")
    public String addNewBook(@ModelAttribute Book book){
        repository.save(book);
        return "redirect:/";
    }

    @GetMapping("/editbook/{id}")
    public String editBookPage(
            @PathVariable Long id,
            Model model
    ){
        model.addAttribute("book", repository.findById(id).get());
        return "editbook";
    }

    @PostMapping("/saveedits")
    public String saveBookEdits(
            @ModelAttribute Book book
    ){
        repository.save(book);
        return "redirect:/";
    }


}
