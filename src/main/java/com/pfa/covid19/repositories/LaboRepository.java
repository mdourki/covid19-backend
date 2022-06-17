package com.pfa.covid19.repositories;

import com.pfa.covid19.entities.Labo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaboRepository extends JpaRepository<Labo , Integer>{
    List<Labo> findByVilleID(int villeId);
}
