package com.example.datasource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
public class CityController {
    private CityRepository cityRepository;

    public CityController(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }


    @GetMapping("/")
    public String aRandomViewPage(Model model){
        model.addAttribute("numOfCity" ,cityRepository.count());
        List<City> cityList=(List<City>)cityRepository.findAll();
        Set<String> continents = new HashSet<>();
        for (City city : cityList) {
            continents.add(city.getCountry().getContinent());
        }

        model.addAttribute("continents",continents);
        return "view";
    }
}

