package com.example.restcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Controller
@RestController
@SpringBootApplication
public class RestControllerApplication {
    static List<String> larsMonsenFact = new ArrayList<>();


    public static void main(String[] args) {
        SpringApplication.run(RestControllerApplication.class, args);
        larsMonsenFact.add("Lars Monsen er den eneste som har drept en grizzlybjørn med dens egne tenner.");
        larsMonsenFact.add("Lars Monsen har ikke med seg boksåpner på tur. Han spiser hermetikken hel.");
        larsMonsenFact.add("Det amerikanske forsvaret brukte Lars Monsen som fasit da de utviklet GPS.");
        larsMonsenFact.add("Lars har ugler i Monsen.");
        larsMonsenFact.add("Lars Monsen har ikke føtter. Han har fjellsko.");
        larsMonsenFact.add("Fjellvettreglene er en stiloppgave Lars Monsen skrev i første klasse på barneskolen.");
        larsMonsenFact.add("Ironisk nok tror ikke Lars Monsen på at det finnes utfordringer - det finnes bare pyser.");
        larsMonsenFact.add("Det finnes ikke ekko i fjellet, det er bare Lars Monsen som kødder med deg.");
        larsMonsenFact.add("En gang ble Lars Monsen bitt av en klapperslange. Etter fem timer med uutholdelige smerter døde slangen.");
        larsMonsenFact.add("Lars Monsen plantet Ibsens Ripsbusker og alle de andre buskvekstene.");
    }

    @GetMapping("/rBoolean")
    public boolean isTrue() {
        return true;
    }

    @GetMapping("/rString")
    public String hello() {
        return "hello";
    }

    @GetMapping("/rInt")
    public int isFive() {
        return 5;
    }

    @GetMapping("/plusFive")
    public String numPlusFive(@RequestParam int num) {
        return
                "Your number: " + num + " Result: " + (5 + num);
    }

    @GetMapping("/Academy")
    public String academy() {
        return "Academy";
    }

    @GetMapping("/bigAcademy")
    public String bigAcademy() {
        return "<html><body><h1>Academy</h1></body></html>";
    }


    @GetMapping("/book")
    public Book getBook() {
        Book b = new Book(200, "Lord of the Rings", "J.R.R. Tolkien");
        return b;
    }

    @GetMapping("/bookList")
    public List<Book> getBookList() {
        return Arrays.asList(
                new Book(200, "LOTR", "Tolkien"),
                new Book(150, "Hobbit", "Tolkien"),
                new Book(200, "HP1", "Rowling"),
                new Book(140, "Map of Bones", "Rollings")
        );
    }

    @GetMapping("/hello")
    public String helloString(@RequestParam String input) {
        if (HttpServletResponse.SC_BAD_REQUEST==400){
            return "You forgot to add your input. Please use https://localhost:8080/hello?input=yourinput";
        }
        return "Hello " + input;
    }

    @GetMapping("/pathVari/{input}")
    public String helloPathVari(@PathVariable String input) {
        return "Hello " + input;
    }

    @GetMapping("/helloStranger")
    public String helloStranger(@RequestParam(required = false, defaultValue = "Stranger") String input) {
        return "Hello " + input;
    }

    @RequestMapping({"/optionalPathVari/{input}", "/optionalPathVari"})
    public String helloOptionalPathVari(@PathVariable(required = false) String input) {
        if (input == null) {
            return "Hello Stranger from optional path variable";
        }
        return "Hello " + input;

    }


    @GetMapping("/upperCase")
    public String toUpperCase(@RequestParam boolean isUpperCase) {
        String output = "hello world";
        return isUpperCase ? output.toUpperCase() : output;
    }

    // http://localhost:8080/twoNames?firstName=Abdur&lastName=Jalil
    @GetMapping("/twoNames")
    public String getTwoNames(@RequestParam String firstName, @RequestParam String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

    // http://localhost:8080/pathTwoNames/Abdur%20Rahman/Jalil --> Hello Abdur Rahman Jalil
    @GetMapping("/pathTwoNames/{firstName}/{lastName}")
    public String getPathTwoNames(@PathVariable String firstName, @PathVariable String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

    @GetMapping("/erdetfredag")
    public String erDetHelg(){
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE"));
        if ("fredag".equals(today)){
            return "<html><body><h1>Det er fredag!!</h1></body></html>";
        }
        else if ("lørdag".equals(today)||"søndag".equals(today)){
            return "Det er helg!";
        }
        return "Det er ikke fredag. Det er bare " + today;
    }


    @GetMapping(value = "/larsmonsen", produces = "text/html")
    public String larsMonsenFactsHtml(
            @RequestParam(required = false, defaultValue = "Lars") String firstName,
            @RequestParam(required = false, defaultValue = "Monsen") String lastName
    )
    {
        return larsMonsen(firstName, lastName);
    }

    @GetMapping(value = "/larsmonsen", produces = "application/json")
    public String larsMonsenFactsJson(
            @RequestParam(required = false, defaultValue = "Lars") String firstName,
            @RequestParam(required = false, defaultValue = "Monsen") String lastName
        )
    {


        return larsMonsen(firstName, lastName);
    }

    public String larsMonsen(String firstName, String lastName){
        String fact = larsMonsenFact.get(ThreadLocalRandom.current().nextInt(larsMonsenFact.size()));
        String newFact = fact.replace("Lars", firstName);
        String outputFact = newFact.replace("Monsen", lastName);
        return "<html><body><h1>"+ outputFact + "</h1></body></html>";
    }

    @GetMapping("/reqresponse")
    public String reqResponse(HttpServletRequest req, HttpServletResponse resp){
        resp.
        return "";
    }

}

