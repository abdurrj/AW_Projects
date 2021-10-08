package com.example.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
			@RequestParam(required = false, defaultValue = "10") int pageSize
	){

		if (page<1){
			page=1;
		}

		int[] pageList = new int[pageSize];
		for (int i = 1; i<=pageList.length;i++){
			pageList[i-1] = i;
		}

		model.addAttribute("viewPages", pageList);

		List<Book> bookList = bookRepository.getPage(page-1, pageSize);
		model.addAttribute("currentPage", page);

		model.addAttribute("bookList", bookList);
		return "view";
	}

	@GetMapping("/{currentPage}/{id}")
	public String showBookDetails(
			Model model,
			@PathVariable int id,
			@PathVariable int currentPage
	){
		Book selectedBook = bookRepository.getBook(id);
		selectedBook.setCurrentPage(currentPage);
		model.addAttribute("book", selectedBook);
		return "selectedbook";
	}

}

