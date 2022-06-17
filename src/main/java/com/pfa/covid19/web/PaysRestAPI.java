package com.pfa.covid19.web;

import com.pfa.covid19.entities.Pays;
import com.pfa.covid19.entities.Region;
import com.pfa.covid19.exceptions.PaysNotFoundException;
import com.pfa.covid19.services.PaysService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class PaysRestAPI {
    private PaysService paysService;

    @GetMapping("/pays")
    public List<Pays> listPays() {
        return paysService.listPays();
    }

    @GetMapping("/pays/{paysID}")
    public Pays getPays(@PathVariable int paysID) throws PaysNotFoundException {
        return paysService.getPays(paysID);
    }

    @GetMapping("/pays/{paysID}/regions")
    public List<Region> listRegions(@PathVariable int paysID) {
        return paysService.listRegions(paysID);
    }

    @GetMapping("/pays/{paysID}/totalPositiveCases")
    public int totalPositiveCases(@PathVariable int paysID) {
        return paysService.totalPositiveCases(paysID);
    }

    @GetMapping("/pays/{paysID}/totalNegativeCases")
    public int totalNegativeCases(@PathVariable int paysID) {
        return paysService.totalNegativeCases(paysID);
    }

    @GetMapping("/pays/{paysID}/totalCriticalCases")
    public int totalCriticalCases(@PathVariable int paysID) {
        return paysService.totalCriticalCases(paysID);
    }

    @GetMapping("/pays/{paysID}/totalDeathCases")
    public int totalDeathCases(@PathVariable int paysID) {
        return paysService.totalDeathCases(paysID);
    }
}
