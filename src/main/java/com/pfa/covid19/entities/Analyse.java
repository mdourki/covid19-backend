package com.pfa.covid19.entities;

import com.pfa.covid19.enums.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Analyse {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Enumerated(EnumType.STRING)
    private Result result;
    private Date date;
    @ManyToOne
    private Labo labo;
    @ManyToOne
    private Patient patient;
}
