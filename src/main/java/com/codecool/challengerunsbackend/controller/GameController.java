package com.codecool.challengerunsbackend.controller;


import com.codecool.challengerunsbackend.entity.Game;
import com.codecool.challengerunsbackend.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/games")
    public ResponseEntity<List<Game>> findAllGames(){
        return ResponseEntity.ok(gameRepository.findAll());
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable("id") Long id){
        return ResponseEntity.ok(gameRepository.getGameById(id));
    }
}
