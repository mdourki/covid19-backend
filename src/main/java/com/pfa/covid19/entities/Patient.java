package com.pfa.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean sick;
    @OneToMany(mappedBy = "patient" , fetch = FetchType.LAZY)
    private List<Analyse> analyses;
}
