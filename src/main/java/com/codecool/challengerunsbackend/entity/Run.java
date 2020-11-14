package com.codecool.challengerunsbackend.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Run {
    @Id
    @GeneratedValue
    private Long id;

    private String category;

    @ManyToOne
    private Game game;

    @ElementCollection
    private List<String> splits;

}
