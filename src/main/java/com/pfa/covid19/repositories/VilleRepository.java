package com.pfa.covid19.repositories;

import com.pfa.covid19.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VilleRepository extends JpaRepository<Ville , Integer> {
    List<Ville> findByRegionID(int regionId);
}
