package com.codecool.challengerunsbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Area {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Split split;

    @ElementCollection
    @Singular
    private List<String> pickUps;

    @ElementCollection
    @Singular
    private List<String> acquiredLevels;

    @ElementCollection
    @Singular
    private List<String> upgrades;

    @ElementCollection
    @Singular
    private List<String> enemies;
}
