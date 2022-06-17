package com.pfa.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Pays {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String Nom;
    @OneToMany(mappedBy = "pays" , fetch = FetchType.LAZY)
    private List<Region> regions;
}
