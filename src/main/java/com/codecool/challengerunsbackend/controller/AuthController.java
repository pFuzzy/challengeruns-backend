package com.codecool.challengerunsbackend.controller;

import com.codecool.challengerunsbackend.entity.CrUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CrUser crUser){
        System.out.println(crUser.toString());
        return ResponseEntity.ok("Ok");
    }
}
