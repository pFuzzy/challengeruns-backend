package com.codecool.challengerunsbackend.repository;

import com.codecool.challengerunsbackend.entity.Category;
import com.codecool.challengerunsbackend.entity.Game;
import com.codecool.challengerunsbackend.entity.Run;
import com.codecool.challengerunsbackend.entity.Split;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class GameRepositoryTest {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private RunRepository runRepository;

    @Autowired
    private SplitRepository splitRepository;

    @Test
    public void savingGameSavesRunsAndSplits() {
        Split testSplit1 = Split.builder()
                .name("Asylum demon")
                .build();
        Split testSplit2 = Split.builder()
                .name("Chaos witch Quelaag")
                .build();
        Split testSplit3 = Split.builder()
                .name("Bell gargoyles")
                .build();
        Run testRun = Run.builder()
                .category(Category.NO_HIT)
                .split(testSplit1)
                .split(testSplit2)
                .split(testSplit3)
                .build();
        Game testGame = Game.builder()
                .title("Dark Souls 1")
                .run(testRun)
                .build();

        testSplit1.setRun(testRun);
        testSplit2.setRun(testRun);
        testSplit3.setRun(testRun);
        testRun.setGame(testGame);

        gameRepository.save(testGame);
        assertThat(gameRepository.findAll())
                .hasSize(1);
        assertThat(runRepository.findAll())
                .hasSize(1)
                .allMatch(run -> run.getGame() != null)
                .anyMatch(run -> run.getCategory().equals(Category.NO_HIT));
        assertThat(splitRepository.findAll())
                .hasSize(3)
                .allMatch(split -> split.getRun() != null)
                .anyMatch(split -> split.getName().equals("Asylum demon"));

    }

    @Test(expected = DataIntegrityViolationException.class)
    public void gameTitleIsNotNull() {
        Game testGame1 = Game.builder().build();

        gameRepository.saveAndFlush(testGame1);

    }

    @Test(expected = DataIntegrityViolationException.class)
    public void gameTitleIsUnique() {
        Game testGame1 = Game.builder()
                .title("Title is same")
                .build();

        gameRepository.saveAndFlush(testGame1);

        Game testGame2 = Game.builder()
                .title("Title is same")
                .build();
        gameRepository.saveAndFlush(testGame2);
    }

    @Test
    public void removingGameRemovesRunsAndSplits() {
        Split testSplit1 = Split.builder()
                .name("Asylum demon")
                .build();
        Run testRun = Run.builder()
                .category(Category.NO_HIT)
                .split(testSplit1)
                .build();
        Game testGame = Game.builder()
                .title("Dark Souls 1")
                .run(testRun)
                .build();
        testSplit1.setRun(testRun);
        testRun.setGame(testGame);

        gameRepository.save(testGame);
        gameRepository.deleteAll();

        assertThat(gameRepository.findAll())
                .hasSize(0);
        assertThat(runRepository.findAll())
                .hasSize(0);
        assertThat(splitRepository.findAll())
                .hasSize(0);
    }

    @Test
    public void getGameByTitle() {
        Run testRun1 = Run.builder()
                .category(Category.NO_HIT)
                .build();
        Run testRun2 = Run.builder()
                .category(Category.NO_HIT)
                .build();
        Game testGame = Game.builder()
                .title("Test title")
                .run(testRun1)
                .run(testRun2)
                .build();

        testRun1.setGame(testGame);
        testRun2.setGame(testGame);
        gameRepository.save(testGame);

        assertThat(gameRepository.getGameByTitle("Test title").equals(testGame));
        assertThat(gameRepository.getGameByTitle("Test title").getRuns().equals(Lists.newArrayList(testRun1,testRun2)));
    }
}