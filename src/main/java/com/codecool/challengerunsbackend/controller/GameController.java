package com.codecool.challengerunsbackend.controller;


import com.codecool.challengerunsbackend.entity.Game;
import com.codecool.challengerunsbackend.entity.Run;
import com.codecool.challengerunsbackend.repository.GameRepository;
import com.codecool.challengerunsbackend.repository.RunRepository;
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

    @Autowired
    private RunRepository runRepository;

    @GetMapping("/games")
    public ResponseEntity<List<Game>> findAllGames(){
        return ResponseEntity.ok(gameRepository.findAll());
    }

    @GetMapping("/games/{gameId}")
    public ResponseEntity<Game> getGameById(@PathVariable("gameId") Long gameId){
        return ResponseEntity.ok(gameRepository.getGameById(gameId));
    }

    @GetMapping("/runs/{runId}")
    public ResponseEntity<Run> getRunById(@PathVariable("runId") Long runId){
        return ResponseEntity.ok(runRepository.getRunById(runId));
    }
}
