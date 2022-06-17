package com.pfa.covid19.services;

import com.pfa.covid19.entities.Pays;
import com.pfa.covid19.entities.Region;
import com.pfa.covid19.exceptions.PaysNotFoundException;

import java.util.List;

public interface PaysService {
    List<Pays> listPays();
    List<Region> listRegions(int paysID);
    Pays getPays(int paysID) throws PaysNotFoundException;
    int totalPositiveCases(int paysID);
    int totalNegativeCases(int paysID);
    int totalCriticalCases(int paysID);
    int totalDeathCases(int paysID);
}
