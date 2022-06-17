package com.pfa.covid19.repositories;

import com.pfa.covid19.entities.Pays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaysRepository extends JpaRepository<Pays , Integer> {
}
