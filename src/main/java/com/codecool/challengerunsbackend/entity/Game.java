package com.codecool.challengerunsbackend.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(mappedBy = "game", cascade = CascadeType.PERSIST)
    @Singular
    private List<Run> runs;
}
