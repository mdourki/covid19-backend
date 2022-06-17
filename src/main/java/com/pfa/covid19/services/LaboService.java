package com.pfa.covid19.services;

import com.pfa.covid19.entities.Analyse;
import com.pfa.covid19.entities.Labo;
import com.pfa.covid19.exceptions.LaboNotFoundException;

import java.util.List;

public interface LaboService {
    List<Labo> listLabos();
    List<Analyse> listAnalyses(int laboID);
    Labo getLabo(int laboID) throws LaboNotFoundException;
    int totalPositiveCases(int laboID) throws LaboNotFoundException;
    int totalNegativeCases(int laboID) throws LaboNotFoundException;
    int totalCriticalCases(int laboID) throws LaboNotFoundException;
    int totalDeathCases(int laboID) throws LaboNotFoundException;
}
