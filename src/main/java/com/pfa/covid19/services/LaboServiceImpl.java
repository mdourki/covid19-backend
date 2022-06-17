package com.pfa.covid19.services;

import com.pfa.covid19.entities.Analyse;
import com.pfa.covid19.entities.Labo;
import com.pfa.covid19.exceptions.LaboNotFoundException;
import com.pfa.covid19.repositories.AnalyseRepository;
import com.pfa.covid19.repositories.LaboRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class LaboServiceImpl implements LaboService{

    private LaboRepository laboRepository;
    private AnalyseRepository analyseRepository;

    @Override
    public List<Labo> listLabos() {
        List<Labo> labos = laboRepository.findAll();
        return labos;
    }

    @Override
    public List<Analyse> listAnalyses(int laboID) {
        List<Analyse> analyses = analyseRepository.findByLaboID(laboID);
        return analyses;
    }

    @Override
    public Labo getLabo(int laboID) throws LaboNotFoundException {
        Labo labo = laboRepository.findById(laboID).orElse(null);
        if(labo==null) throw new LaboNotFoundException("Labo non trouvé");
        return labo;
    }

    @Override
    public int totalPositiveCases(int laboID) throws LaboNotFoundException {
        int total=0;
        Labo labo = getLabo(laboID);
        total = labo.getPositiveCases();
        return total;
    }

    @Override
    public int totalNegativeCases(int laboID) throws LaboNotFoundException {
        int total=0;
        Labo labo = getLabo(laboID);
        total = labo.getNegativeCases();
        return total;
    }

    @Override
    public int totalCriticalCases(int laboID) throws LaboNotFoundException {
        int total=0;
        Labo labo = getLabo(laboID);
        total = labo.getCriticalCases();
        return total;
    }

    @Override
    public int totalDeathCases(int laboID) throws LaboNotFoundException {
        int total=0;
        Labo labo = getLabo(laboID);
        total = labo.getNegativeCases();
        return total;
    }
}
