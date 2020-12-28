package com.codecool.challengerunsbackend.controller;

import com.codecool.challengerunsbackend.entity.CrUser;
import com.codecool.challengerunsbackend.repository.CrUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {

    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Autowired
    private CrUserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CrUser user) {
        String response = "Registration successful";
        if (userRepository.existsCrUserByUsername(user.getUsername())) {
            response = "Username already exists!";
        } else if (userRepository.existsCrUserByEmail(user.getEmail())) {
            response = "E-mail already in use";
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
        System.out.println(userRepository.findAll());
        return ResponseEntity.ok(response);
    }
}
