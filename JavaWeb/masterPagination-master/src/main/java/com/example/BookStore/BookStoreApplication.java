package com.example.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class BookStoreApplication {

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@GetMapping("/")
	public String viewPage(
			Model model,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int pageSize,
			HttpSession session
	){

		if (page==0){
			page=1;
		}

		int[] pageList = new int[10];
		for (int i = 1; i<=pageList.length;i++){
			pageList[i-1] = i;
		}

		model.addAttribute("viewPages", pageList);

		List<Book> bookList = bookRepository.getPage(page-1, pageSize);
		session.setAttribute("currentPage", page);
		model.addAttribute("currentPage", page);


		model.addAttribute("bookList", bookList);
		return "view";
	}

	@GetMapping("/{id}")
	public String showBookDetails(
			Model model,
			HttpSession session,
			@PathVariable int id
	){
		int currentPage = (int) session.getAttribute("currentPage");
		model.addAttribute("currentPage", currentPage);
		Book selectedBook = bookRepository.getBook(id);
		model.addAttribute("book", selectedBook);
		return "selectedbook";
	}





}

