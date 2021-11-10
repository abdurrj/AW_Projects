package com.example.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/")
    public String start() {
        return "start";
    }

    @GetMapping("/secret")
    public String secret(@AuthenticationPrincipal OAuth2User principal, Model model) {
        String username = principal.getAttribute("login");
        model.addAttribute("username", username);
        return "secret";
    }
}
