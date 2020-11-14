package com.codecool.challengerunsbackend.entity;


import lombok.*;

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

    @Column(nullable = false)
    private String category;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Game game;

    @OneToMany(mappedBy = "run", cascade = CascadeType.PERSIST)
    @Singular
    @EqualsAndHashCode.Exclude
    private List<Split> splits;

}
