package com.codecool.challengerunsbackend;

import com.codecool.challengerunsbackend.entity.Game;
import com.codecool.challengerunsbackend.entity.Run;
import com.codecool.challengerunsbackend.entity.Split;
import com.codecool.challengerunsbackend.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ChallengeRunsBackendApplication {

    @Autowired
    private GameRepository gameRepository;

    public static void main(String[] args) {
        SpringApplication.run(ChallengeRunsBackendApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
//            Split asylum = Split.builder()
//                    .name("Asylum demon")
//                    .build();
//            Split quelaag = Split.builder()
//                    .name("Chaos witch Quelaag")
//                    .build();
//            Split ceaseless = Split.builder()
//                    .name("Ceaseless Discharge")
//                    .build();
//            Split gargoyles = Split.builder()
//                    .name("Bell Gargoyles")
//                    .build();
//            Split golem = Split.builder()
//                    .name("Iron Golem")
//                    .build();
//            Split ornstein = Split.builder()
//                    .name("Dragonslayer Ornstein and Executioner Smough")
//                    .build();
//            Split pinwheel = Split.builder()
//                    .name("Pinwheel")
//                    .build();
//            Split nito = Split.builder()
//                    .name("Gravelord Nito")
//                    .build();
//            Split sif = Split.builder()
//                    .name("Great Grey Wolf Sif")
//                    .build();
//            Split seath = Split.builder()
//                    .name("Seath the scaleless")
//                    .build();
//            Split boc = Split.builder()
//                    .name("Bed of chaos")
//                    .build();
//            Split fourKings = Split.builder()
//                    .name("Four kings")
//                    .build();
//            Split gwyn = Split.builder()
//                    .name("Gwyn, Lord of Cinder")
//                    .build();
//            Run ds1Any = Run.builder()
//                    .category("Any%")
//                    .split(asylum)
//                    .split(quelaag)
//                    .split(ceaseless)
//                    .split(gargoyles)
//                    .split(golem)
//                    .split(ornstein)
//                    .split(pinwheel)
//                    .split(nito)
//                    .split(sif)
//                    .split(seath)
//                    .split(boc)
//                    .split(fourKings)
//                    .split(gwyn)
//                    .build();
//            Game ds1 = Game.builder()
//                    .title("Dark souls 1")
//                    .run(ds1Any)
//                    .build();
//
//            asylum.setRun(ds1Any);
//            quelaag.setRun(ds1Any);
//            ceaseless.setRun(ds1Any);
//            gargoyles.setRun(ds1Any);
//            golem.setRun(ds1Any);
//            ornstein.setRun(ds1Any);
//            pinwheel.setRun(ds1Any);
//            nito.setRun(ds1Any);
//            sif.setRun(ds1Any);
//            seath.setRun(ds1Any);
//            boc.setRun(ds1Any);
//            fourKings.setRun(ds1Any);
//            gwyn.setRun(ds1Any);
//
//            ds1Any.setGame(ds1);
//
//            gameRepository.save(ds1);


        };
    }
}
