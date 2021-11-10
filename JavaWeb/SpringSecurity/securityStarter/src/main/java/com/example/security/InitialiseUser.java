package com.example.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialiseUser {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public InitialiseUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("init")
    public void init(){
        User user = userRepository.findByUsername("user");
        if (user == null){
            user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("123"));
            userRepository.save(user);
        }

    }
}
