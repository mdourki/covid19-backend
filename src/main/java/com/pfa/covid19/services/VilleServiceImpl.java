package com.pfa.covid19.services;

import com.pfa.covid19.entities.Labo;
import com.pfa.covid19.entities.Ville;
import com.pfa.covid19.exceptions.VilleNotFoundException;
import com.pfa.covid19.repositories.LaboRepository;
import com.pfa.covid19.repositories.VilleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class VilleServiceImpl implements VilleService{

    private VilleRepository villeRepository;
    private LaboRepository laboRepository;


    @Override
    public List<Ville> listVilles() {
        List<Ville> villes = villeRepository.findAll();
        return villes;
    }

    @Override
    public List<Labo> listLabos(int villeID) {
        List<Labo> labos = laboRepository.findByVilleID(villeID);
        return labos;
    }

    @Override
    public Ville getVille(int villeID) throws VilleNotFoundException {
        Ville ville = villeRepository.findById(villeID).orElse(null);
        if(ville==null) throw new VilleNotFoundException("Ville non trouvée");
        return ville;
    }

    @Override
    public int totalPositiveCases(int villeID) {
        int total = 0;
        List<Labo> labos = listLabos(villeID);
        for (Labo labo : labos) {
            total+= labo.getPositiveCases();
        }
        return total;
    }

    @Override
    public int totalNegativeCases(int villeID) {
        int total = 0;
        List<Labo> labos = listLabos(villeID);
        for (Labo labo : labos) {
            total+= labo.getNegativeCases();
        }
        return total;
    }

    @Override
    public int totalCriticalCases(int villeID) {
        int total = 0;
        List<Labo> labos = listLabos(villeID);
        for (Labo labo : labos) {
            total+= labo.getCriticalCases();
        }
        return total;
    }

    @Override
    public int totalDeathCases(int villeID) {
        int total = 0;
        List<Labo> labos = listLabos(villeID);
        for (Labo labo : labos) {
            total+= labo.getDeathCases();
        }
        return total;
    }
}