package com.example.oppgavesetseks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class TestClass {

    @GetMapping("/test")
    public String testTask(){
        return "task1";
    }

    @GetMapping("/modeltest")
    public String testModel(Model model){
        model.addAttribute("name", "Abdur");
        return "task2";
    }

    @GetMapping("/modeltest2")
    public String testModel2(Model model, @RequestParam String firstName){
        model.addAttribute("name", firstName);
        return "task3";
    }

    @GetMapping("/modeltest3")
    public String testmodel3(
            Model model,
            @RequestParam(
                    required = false,
                    defaultValue = "Academy"
            ) String firstName)
    {
        model.addAttribute("name", firstName);
        return "task4";
    }

    @GetMapping("/modeltest4/{firstName}")
    public String testmodel4(
            Model model,
            @PathVariable String firstName){
        model.addAttribute("name", firstName);
        return "task5";
    }

    @GetMapping("/booktest")
    public String bookTest(Model model){
        Book book = new Book(200, "LOTR", "J.R.R. Tolkien");
        model.addAttribute("book", book);
        return "task6-book";
    }

    @GetMapping("/booktest2")
    public String bookTest2(Model model){
        List<Book> bookList = Arrays.asList(
            new Book(300, "LOTR", "Tolkien"),
            new Book(210, "Hobbit", "Tolkien"),
            new Book(250, "HP1", "Rowling"),
            new Book(140, "Map of Bones", "Rollings"),
            new Book(140, "Sandstorm", "Rollings"),
            new Book(220, "HP2", "Rowling")
        );
        model.addAttribute("bookList", bookList);
        return "task7-book";
    }


    @GetMapping("/booktest3")
    public String bookTest3(Model model){
        List<Book> bookList = Arrays.asList(
                new Book(300, "LOTR", "Tolkien"),
                new Book(210, "Hobbit", "Tolkien"),
                new Book(250, "HP1", "Rowling"),
                new Book(140, "Map of Bones", "Rollings"),
                new Book(140, "Sandstorm", "Rollings"),
                new Book(220, "HP2", "Rowling")
        );
        model.addAttribute("bookList", bookList);
        return "task8-book";
    }
}
