package com.example.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/")
    public String start() {
        return "start";
    }

    @GetMapping("/secret")
    public String secret() {
        return "secret";
    }

    @GetMapping("/home")
    public String home(){ return "home";}

    @GetMapping("/login")
    public String loginpage(){ return "login"; }

    @GetMapping("/admin")
    public String adminpage(){ return "admin"; }
}
