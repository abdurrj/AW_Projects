package com.example.datasource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
class DataSourceApplicationTests {

    @Autowired
    private CityRepository cityRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldFindCorrectNumberOfCities(){
        Assertions.assertEquals(4078, cityRepository.count());
    }

    @Test
    void shouldFindDataForKabul(){
        City kabul = cityRepository.findById(1L).get();
        Assertions.assertEquals("Kabul", kabul.getName());
        Assertions.assertEquals("AFG", kabul.getCountry().getCode());
        Assertions.assertEquals("Kabol", kabul.getDistrict());
        Assertions.assertEquals(1780000, kabul.getPopulation());
    }




}
