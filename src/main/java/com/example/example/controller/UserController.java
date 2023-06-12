package com.example.example.controller;

import com.example.example.entity.User;
import com.example.example.entity.Role;
import com.example.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        Optional<User> userFromDB = userRepository.findByEmail(user.getEmail());
        if (userFromDB.isEmpty()) {
            String password = user.getPassword();
//            String encodedPassword = passwordEncoder.encode(password);
//            user.setPassword(encodedPassword);
            user.setRole(Role.USER);
            userRepository.save(user);
        }
        return "redirect:/";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "register";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }
}