package com.codecool.challengerunsbackend.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Split {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Run run;
}
