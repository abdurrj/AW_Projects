package com.abdur.checkpoint_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@SpringBootApplication
public class Checkpoint4Application {

    public static void main(String[] args) {
        SpringApplication.run(Checkpoint4Application.class, args);
    }


    // Nivå 1 Start
    @GetMapping("/")
    public String sumOfTwoNums(
            Model model,
            @RequestParam(required = false, defaultValue = "0") int number1,
            @RequestParam(required = false, defaultValue = "0") int number2
    ){
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("sum", number1+number2);
        return "view";
    }
    // Nivå 1 Slutt


    // Nivå 2 Start
    @GetMapping("/addyournumber")
    public String showGrowingNumbers(
            HttpSession session,
            Model model
    ){
        String currentSum = (String)session.getAttribute("currentSum");
        if (currentSum == null){
            currentSum = "0";
            session.setAttribute("currentSum", currentSum);
        }
        model.addAttribute("currentSum", currentSum);
        return "addnumbers";
    }

    @PostMapping("/addyournumber")
    public String addToGrowingNumbers(
            HttpSession session,
            @RequestParam(required = false, defaultValue = "0") int numToAdd
    ) throws NegativeNumberException {
        String currentSum = (String)session.getAttribute("currentSum");
        int currentSumAsInt = Integer.parseInt(currentSum);
        if (numToAdd<0){
            throw new NegativeNumberException();
        }
        int newSum = currentSumAsInt + numToAdd;
        session.setAttribute("currentSum", String.valueOf(newSum));

        return "redirect:/addyournumber";
    }

    @ResponseStatus
    @ExceptionHandler(NumberFormatException.class)
    public String invalidNumber(
            HttpServletResponse response
    ) throws IOException {
        response.sendError(71808);
        return "error";
    }
    // Nivå 2 Slutt

}
