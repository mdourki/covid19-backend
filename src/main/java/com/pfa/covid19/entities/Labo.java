package com.pfa.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Labo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String Nom;
    private int positiveCases;
    private int negativeCases;
    private int criticalCases;
    private int deathCases;
    @ManyToOne
    private Ville ville;
    @OneToMany(mappedBy = "labo" , fetch = FetchType.LAZY)
    private List<Analyse> analyses;
}
