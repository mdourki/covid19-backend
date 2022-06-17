package com.pfa.covid19.web;

import com.pfa.covid19.entities.Region;
import com.pfa.covid19.entities.Ville;
import com.pfa.covid19.exceptions.RegionNotFoundException;
import com.pfa.covid19.services.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class RegionRestAPI {
    private RegionService regionService;

    @GetMapping("/regions")
    public List<Region> listRegions() {
        return regionService.listRegions();
    }

    @GetMapping("/regions/{regionId}")
    public Region getRegion(@PathVariable int regionId) throws RegionNotFoundException {
        return regionService.getRegion(regionId);
    }

    @GetMapping("/regions/{regionId}/villes")
    public List<Ville> listVilles(@PathVariable int regionId) {
        return regionService.listVilles(regionId);
    }

    @GetMapping("/regions/{regionId}/totalPositiveCases")
    public int totalPositiveCases(@PathVariable int regionId) {
        return regionService.totalPositiveCases(regionId);
    }

    @GetMapping("/regions/{regionId}/totalNegativeCases")
    public int totalNegativeCases(@PathVariable int regionId) {
        return regionService.totalNegativeCases(regionId);
    }

    @GetMapping("/regions/{regionId}/totalCriticalCases")
    public int totalCriticalCases(@PathVariable int regionId){
        return regionService.totalCriticalCases(regionId);
    }

    @GetMapping("/regions/{regionId}/totalDeathCases")
    public int totalDeathCases(@PathVariable int regionId) {
        return regionService.totalDeathCases(regionId);
    }
}
