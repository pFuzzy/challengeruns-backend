package com.codecool.challengerunsbackend.controller;

import com.codecool.challengerunsbackend.entity.CrUser;
import com.codecool.challengerunsbackend.repository.CrUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    private CrUserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CrUser crUser){
        userRepository.save(crUser);
        System.out.println(userRepository.findAll());
        return ResponseEntity.ok("Ok");
    }
}
