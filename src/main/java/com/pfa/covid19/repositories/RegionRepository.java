package com.pfa.covid19.repositories;

import com.pfa.covid19.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Integer> {
    List<Region> findByPaysID(int paysId);
}
