package com.pfa.covid19.services;

import com.pfa.covid19.entities.Region;
import com.pfa.covid19.entities.Ville;
import com.pfa.covid19.exceptions.RegionNotFoundException;
import com.pfa.covid19.repositories.RegionRepository;
import com.pfa.covid19.repositories.VilleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class RegionServiceImpl implements RegionService{

    private RegionRepository regionRepository;
    private VilleRepository villeRepository;
    private VilleServiceImpl villeService;

    @Override
    public List<Region> listRegions() {
        List<Region> regions = regionRepository.findAll();
        return regions;
    }

    @Override
    public List<Ville> listVilles(int regionID) {
        List<Ville> villes = villeRepository.findByRegionID(regionID);
        return villes;
    }

    @Override
    public Region getRegion(int regionID) throws RegionNotFoundException {
        Region region = regionRepository.findById(regionID).orElse(null);
        if(region==null) throw new RegionNotFoundException("Région non trouvée");
        return region;
    }

    @Override
    public int totalPositiveCases(int regionID) {
        int total=0;
        List<Ville> villes = listVilles(regionID);
        for (Ville ville : villes) {
            total+= villeService.totalPositiveCases(ville.getID());
        }
        return total;
    }

    @Override
    public int totalNegativeCases(int regionID) {
        int total=0;
        List<Ville> villes = listVilles(regionID);
        for (Ville ville : villes) {
            total+= villeService.totalNegativeCases(ville.getID());
        }
        return total;
    }

    @Override
    public int totalCriticalCases(int regionID) {
        int total=0;
        List<Ville> villes = listVilles(regionID);
        for (Ville ville : villes) {
            total+= villeService.totalCriticalCases(ville.getID());
        }
        return total;
    }

    @Override
    public int totalDeathCases(int regionID) {
        int total=0;
        List<Ville> villes = listVilles(regionID);
        for (Ville ville : villes) {
            total+= villeService.totalDeathCases(ville.getID());
        }
        return total;
    }
}
