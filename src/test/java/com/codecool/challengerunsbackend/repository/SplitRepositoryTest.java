package com.codecool.challengerunsbackend.repository;

import com.codecool.challengerunsbackend.entity.Split;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class SplitRepositoryTest {
    @Autowired
    private SplitRepository splitRepository;

    @Test(expected = DataIntegrityViolationException.class)
    public void runCategoryIsNotNull(){
        Split testRun = Split.builder().build();

        splitRepository.save(testRun);
    }

}