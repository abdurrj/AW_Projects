package com.example.swaggerovelse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//@EnableSwagger2
@Controller
@SpringBootApplication
public class SwaggerOvelseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerOvelseApplication.class, args);
    }



    @RequestMapping(method= RequestMethod.GET, produces = {"text/plain", "application/json"}, value = "/")
    public String hello(){
        return "view";
    }

//    @GetMapping(value = "/", produces = "application/json")
//    @RequestMapping(method= RequestMethod.GET, produces = "application/json")
//    public String helloJason(){
//        return "view";
//    }

    @PostMapping("/")
    public String alsoHello(
            @RequestParam String name,
            @RequestParam(required = false, defaultValue = "3") int num
    ){
        System.out.println(num);
        System.out.println(name);
        return "view";
    }
}
