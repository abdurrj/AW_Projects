package com.example.oppgset9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SpringBootApplication
public class OppgSet9Application {

    public static void main(String[] args) {
        SpringApplication.run(OppgSet9Application.class, args);
    }


    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidNumber() {
        return "error";
    }

    @GetMapping("/view/{id}")
    public String productId(@PathVariable int id) throws invalidProductIdException {
        if (id<0){
            throw new invalidProductIdException();
        }

        return "view";
    }

    @GetMapping("/viu/{id}")
    public String alsoProductId(@PathVariable int id){
        return "view";
    }



}
