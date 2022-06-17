package com.pfa.covid19.repositories;

import com.pfa.covid19.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
