package com.example.resttest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {

    public RestTemplateController() {
    }

    @GetMapping("/mvcquote")
    public String getQuote(RestTemplate restTemplate){
        String quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", String.class);
        return quote;
    }

    @GetMapping("/mvcquote2")
    public Quote getQuote2(RestTemplate restTemplate){
        Quote quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", Quote.class);
        return quote;
    }

}
