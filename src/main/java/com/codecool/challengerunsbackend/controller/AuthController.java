package com.codecool.challengerunsbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {
    @PostMapping("/register")
    public ResponseEntity<?> register(){
        return ResponseEntity.ok("Ok");
    }
}
