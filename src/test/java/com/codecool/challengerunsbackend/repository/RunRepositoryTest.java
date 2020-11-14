package com.codecool.challengerunsbackend.repository;

import com.codecool.challengerunsbackend.entity.Run;
import com.codecool.challengerunsbackend.entity.Split;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class RunRepositoryTest {
    @Autowired
    private RunRepository runRepository;

    @Test(expected = DataIntegrityViolationException.class)
    public void runCategoryIsNotNull(){
        Run testRun = Run.builder().build();

        runRepository.save(testRun);
    }

    @Test
    public void getRunByCategory(){
        Split testSplit1 = Split.builder()
                .name("Asylum demon")
                .build();
        Split testSplit2 = Split.builder()
                .name("Quelaag")
                .build();
        Split testSplit3 = Split.builder()
                .name("Bell gargoyles")
                .build();
        Run testRun = Run.builder()
                .category("Any%")
                .split(testSplit1)
                .split(testSplit2)
                .split(testSplit3)
                .build();

        testSplit1.setRun(testRun);
        testSplit2.setRun(testRun);
        testSplit3.setRun(testRun);

        runRepository.save(testRun);

        assertThat(runRepository.getRunByCategory("Any%").equals(testRun));
        assertThat(runRepository.getRunByCategory("Any%").getSplits().equals(Lists.newArrayList(testSplit1,testSplit2,testSplit3)));
    }

}