package com.example.signup.controller;

import com.example.signup.model.Signup;
import com.example.signup.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/signup")
@CrossOrigin(origins = "http://localhost:3000")
public class SignupController {

    @Autowired
    private SignupService signupService;

    @GetMapping
    public List<Signup> getAllSignups() {
        return signupService.getAllSignups();
    }

    @PostMapping
    public Signup saveSignup(@RequestBody Signup signup) {
        return signupService.saveSignup(signup);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Signup loginData) {
        Optional<Signup> existingUser = signupService.findByEmail(loginData.getEmail());

        if (existingUser.isPresent() && existingUser.get().getPassword().equals(loginData.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else if (!existingUser.isPresent()) {
            return ResponseEntity.status(401).body("You need to signup first");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
