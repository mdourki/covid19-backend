package com.pfa.covid19.repositories;

import com.pfa.covid19.entities.Analyse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnalyseRepository extends JpaRepository<Analyse,Integer> {
    List<Analyse> findByLaboID(int laboId);
    List<Analyse> findByPatientID(int patientId);
}
