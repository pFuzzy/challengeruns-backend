package com.codecool.challengerunsbackend.repository;

import com.codecool.challengerunsbackend.entity.Game;
import com.codecool.challengerunsbackend.entity.Run;
import com.codecool.challengerunsbackend.entity.Split;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class GameRepositoryTest {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private RunRepository runRepository;

    @Autowired
    private SplitRepository splitRepository;

    @Test
    public void savingGameSavesRunsAndSplits(){
        Split asylumDemon = Split.builder()
                .name("Asylum demon")
                .build();
        Split quelaag = Split.builder()
                .name("Chaos witch Quelaag")
                .build();
        Split gargoyles = Split.builder()
                .name("Bell gargoyles")
                .build();
        Run anyPercent = Run.builder()
                .category("Any%")
                .split(asylumDemon)
                .split(quelaag)
                .split(gargoyles)
                .build();
        Game darkSoulOne = Game.builder()
                .title("Dark Souls 1")
                .run(anyPercent)
                .build();
        asylumDemon.setRun(anyPercent);
        quelaag.setRun(anyPercent);
        gargoyles.setRun(anyPercent);
        anyPercent.setGame(darkSoulOne);


        gameRepository.save(darkSoulOne);
        assertThat(gameRepository.findAll())
                .hasSize(1);
        assertThat(runRepository.findAll())
                .hasSize(1);
        assertThat(splitRepository.findAll())
                .hasSize(3);


    }

}