package com.pfa.covid19.services;

import com.pfa.covid19.entities.Labo;
import com.pfa.covid19.entities.Ville;
import com.pfa.covid19.exceptions.VilleNotFoundException;

import java.util.List;

public interface VilleService {
    List<Ville> listVilles();
    List<Labo> listLabos(int villeID);
    Ville getVille(int villeID) throws VilleNotFoundException;
    int totalPositiveCases(int villeID);
    int totalNegativeCases(int villeID);
    int totalCriticalCases(int villeID);
    int totalDeathCases(int villeID);
}
