package com.example.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private BookRepository repository;

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
        List<Book> books = (List<Book>)repository.findAllByOrderByAuthorDesc();
        int from = Math.max(0,page*pageSize);
        int to = Math.min(books.size(),(page+1)*pageSize);

        return books.subList(from, to);
    }

    private int numberOfPages(int pageSize) {
        List<Book> books = (List<Book>)repository.findAll();
        return (int)Math.ceil(new Double(books.size()) / pageSize);
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "form";
    }

    @PostMapping("/save")
    public String set(@Valid @ModelAttribute Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "form";
        }
        repository.save(book);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Book book = repository.findById(id).get();
        model.addAttribute(book);
        return "form";
    }

}
