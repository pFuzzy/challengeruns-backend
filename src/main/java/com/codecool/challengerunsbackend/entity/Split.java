package com.codecool.challengerunsbackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Split {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Run run;

    @ElementCollection
    @Column(nullable = true)
    @Singular("step")
    private List<String> stepByStep;
}
