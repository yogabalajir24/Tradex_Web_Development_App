package com.example.signup.service;

import com.example.signup.model.Signup;
import com.example.signup.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SignupService {

    @Autowired
    private SignupRepository signupRepository;

    public List<Signup> getAllSignups() {
        return signupRepository.findAll();
    }

    public Signup saveSignup(Signup signup) {
        return signupRepository.save(signup);
    }

    public Optional<Signup> findByEmail(String email) {
        return signupRepository.findByEmail(email);
    }
}
