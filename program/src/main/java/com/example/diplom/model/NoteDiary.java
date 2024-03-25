package com.example.diplom.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "noteDiary")
public class NoteDiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "feeling")
    private String feeling;

    @Column(name = "exampleSituation")
    private String exampleSituation;

    @Column(name = "bodilySensations")
    private String bodilySensations;

    @Column(name = "thoughts")
    private String thoughts;

    @Column(name = "behavior")
    private String behavior;

}

