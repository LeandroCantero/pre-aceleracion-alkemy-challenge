package com.example.disney_challenge.controllers;

import com.example.disney_challenge.models.User;
import com.example.disney_challenge.repositories.UserRepository;
import com.example.disney_challenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/register")
    public ResponseEntity<String> showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return ResponseEntity.ok("signup_form");
    }

    @PostMapping("/registration")
    public ResponseEntity<String> processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userService.save(user);

        return ResponseEntity.ok("register_success");
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> listUsers(Model model) {
        var listUsers = userService.findAllUsers();
        model.addAttribute("listUsers:", listUsers);

        return ResponseEntity.ok(listUsers);
    }
}
