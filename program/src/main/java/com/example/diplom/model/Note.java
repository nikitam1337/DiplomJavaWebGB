package com.example.diplom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "createdDate")
    private LocalDate createdDate;

    @Column(name = "feeling")
    private String feeling;

    @Column(name = "lifeSituation")
    private String lifeSituation;

    @Column(name = "telexSensation")
    private String telexSensation;

    @Column(name = "yourActions")
    private String yourActions;

    @Column(name = "myThoughtsAboutOthers")
    private String myThoughtsAboutOthers;

    @Column(name = "myThoughts")
    private String myThoughts;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

}