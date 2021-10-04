package com.example.randomvitsabdur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@SpringBootApplication
public class RandomVitsAbdurApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandomVitsAbdurApplication.class, args);
        RandomVits.generateList();
    }

    @GetMapping("/vits")
    public String vits(){
        RandomVits rv = new RandomVits();
        return rv.displayJoke();
    }

}
