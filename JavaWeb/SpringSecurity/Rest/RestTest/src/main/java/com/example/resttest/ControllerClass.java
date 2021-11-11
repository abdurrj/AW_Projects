package com.example.resttest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;


@Controller
public class ControllerClass {


    @GetMapping("/quote")
    public String getView(Model model, RestTemplate restTemplate){
        Quote quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", Quote.class);

        model.addAttribute("quote", quote);
        return "view";
    }

}
