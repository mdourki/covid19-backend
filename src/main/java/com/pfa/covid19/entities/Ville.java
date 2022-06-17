package com.pfa.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Ville {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String Nom;
    @ManyToOne
    private Region region;
    @OneToMany(mappedBy = "ville" , fetch = FetchType.LAZY)
    private List<Labo> labos;
}
