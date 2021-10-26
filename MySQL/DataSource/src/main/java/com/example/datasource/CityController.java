package com.example.datasource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CityController {
    private CityRepository cityRepository;


    @GetMapping("/")
    public String aRandomViewPage(){

        return "view";
    }
}
