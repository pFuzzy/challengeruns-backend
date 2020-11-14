package com.codecool.challengerunsbackend.repository;

import com.codecool.challengerunsbackend.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
