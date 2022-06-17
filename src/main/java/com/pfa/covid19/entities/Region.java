package com.pfa.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Region {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String Nom;
    @ManyToOne
    private Pays pays;
    @OneToMany(mappedBy = "region" , fetch = FetchType.LAZY)
    private List<Ville> villes;
}
