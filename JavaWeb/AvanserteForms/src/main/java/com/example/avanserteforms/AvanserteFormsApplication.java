package com.example.avanserteforms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@SpringBootApplication
public class AvanserteFormsApplication {
    @Autowired
    MovieRepository movieRepository;

    public Movie movie;

    public static void main(String[] args) {
        SpringApplication.run(AvanserteFormsApplication.class, args);
    }

    @GetMapping("/")
    public String moviePage(
            Model model
    ){

        if (this.movie == null){
            this.movie = new Movie("", "");
        }
        model.addAttribute("movie", movie);
        model.addAttribute("movieGenre", movieGenre.values());

        return "view";
    }

    @PostMapping("/saveMovie")
    public String saveMovie(
            @ModelAttribute Movie movie
    ){
        this.movie.setTitle(movie.getTitle());
        this.movie.setDirector(movie.getDirector());
        this.movie.setForChildren(movie.isForChildren());
        this.movie.setGenre(movie.getGenre());
        System.out.println(movie.getTitle());
        System.out.println(movie.getDirector());
        return "redirect:/";
    }

}
