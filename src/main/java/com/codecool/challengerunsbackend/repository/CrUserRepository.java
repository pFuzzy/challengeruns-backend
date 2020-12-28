package com.codecool.challengerunsbackend.repository;

import com.codecool.challengerunsbackend.entity.CrUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrUserRepository extends JpaRepository<CrUser, Long> {
    boolean existsCrUserByUsername(String username);

    boolean existsCrUserByEmail(String email);


}
