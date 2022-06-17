package com.pfa.covid19.services;

import com.pfa.covid19.entities.Pays;
import com.pfa.covid19.entities.Region;
import com.pfa.covid19.exceptions.PaysNotFoundException;
import com.pfa.covid19.repositories.PaysRepository;
import com.pfa.covid19.repositories.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PaysServiceImpl implements PaysService{

    private PaysRepository paysRepository;
    private RegionRepository regionRepository;
    private RegionServiceImpl regionService;

    @Override
    public List<Pays> listPays() {
        List<Pays> pays = paysRepository.findAll();
        return pays;
    }

    @Override
    public List<Region> listRegions(int paysID) {
        List<Region> regions = regionRepository.findByPaysID(paysID);
        return regions;
    }

    @Override
    public Pays getPays(int paysID) throws PaysNotFoundException {
        Pays pays = paysRepository.findById(paysID).orElse(null);
        if(pays==null) throw new PaysNotFoundException("Pays non trouvé");
        return pays;
    }

    @Override
    public int totalPositiveCases(int paysID) {
        int total=0;
        List<Region> regions = listRegions(paysID);
        for (Region region : regions) {
            total+= regionService.totalPositiveCases(region.getID());
        }
        return total;
    }

    @Override
    public int totalNegativeCases(int paysID) {
        int total=0;
        List<Region> regions = listRegions(paysID);
        for (Region region : regions) {
            total+= regionService.totalNegativeCases(region.getID());
        }
        return total;
    }

    @Override
    public int totalCriticalCases(int paysID) {
        int total=0;
        List<Region> regions = listRegions(paysID);
        for (Region region : regions) {
            total+= regionService.totalCriticalCases(region.getID());
        }
        return total;
    }

    @Override
    public int totalDeathCases(int paysID) {
        int total=0;
        List<Region> regions = listRegions(paysID);
        for (Region region : regions) {
            total+= regionService.totalDeathCases(region.getID());
        }
        return total;
    }
}
