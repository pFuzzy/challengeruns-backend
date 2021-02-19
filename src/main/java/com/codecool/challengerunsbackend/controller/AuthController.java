package com.codecool.challengerunsbackend.controller;

import com.codecool.challengerunsbackend.entity.CrUser;
import com.codecool.challengerunsbackend.repository.CrUserRepository;
import com.codecool.challengerunsbackend.security.JwtTokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class AuthController {

    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CrUserRepository userRepository;

    @Autowired
    private JwtTokenServices jwtTokenServices;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CrUser user) {
        String response = "Registration successful!";
        if (userRepository.existsCrUserByUsername(user.getUsername())) {
            response = "Username already exists!";
        } else if (userRepository.existsCrUserByEmail(user.getEmail())) {
            response = "E-mail already in use!";
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
        System.out.println(userRepository.findAll());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CrUser user){
            Map<Object, Object> model = new HashMap<>();
            try {
                String username = user.getUsername();
                String password = user.getPassword();
                Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
                List<String> roles = authentication.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList());

                String token = jwtTokenServices.createToken(username, roles);

                model.put("status", "Login successful!");
                model.put("username", username);
                model.put("roles", roles);
                model.put("token", token);

                return ResponseEntity.ok(model);

            } catch (AuthenticationException e) {
                model.put("status", "Invalid username or password!");
                return ResponseEntity.ok(model);
            }
    }
}
