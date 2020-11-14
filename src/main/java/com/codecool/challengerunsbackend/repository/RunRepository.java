package com.codecool.challengerunsbackend.repository;

import com.codecool.challengerunsbackend.entity.Run;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunRepository extends JpaRepository<Run, Long> {
    Run getRunByCategory(String category);
}
