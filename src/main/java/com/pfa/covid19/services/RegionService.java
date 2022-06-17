package com.pfa.covid19.services;

import com.pfa.covid19.entities.Pays;
import com.pfa.covid19.entities.Region;
import com.pfa.covid19.entities.Ville;
import com.pfa.covid19.exceptions.RegionNotFoundException;

import java.util.List;

public interface RegionService {
    List<Region> listRegions();
    List<Ville> listVilles(int regionID);
    Region getRegion(int regionID) throws RegionNotFoundException;
    int totalPositiveCases(int regionID);
    int totalNegativeCases(int regionID);
    int totalCriticalCases(int regionID);
    int totalDeathCases(int regionID);
}
