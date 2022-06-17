package com.pfa.covid19.web;

import com.pfa.covid19.entities.Analyse;
import com.pfa.covid19.entities.Labo;
import com.pfa.covid19.exceptions.LaboNotFoundException;
import com.pfa.covid19.services.LaboService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class LaboRestAPI {
    private LaboService laboService;

    @GetMapping("/labos")
    public List<Labo> listLabos() {
        return laboService.listLabos();
    }

    @GetMapping("/labos/{laboID}")
    public Labo getLabo(@PathVariable int laboID) throws LaboNotFoundException {
        return laboService.getLabo(laboID);
    }

    @GetMapping("/labos/{laboID}/analyses")
    public List<Analyse> listAnalyses(@PathVariable int laboID) {
        return laboService.listAnalyses(laboID);
    }

    @GetMapping("/labos/{laboID}/totalPositiveCases")
    public int totalPositiveCases(@PathVariable int laboID) throws LaboNotFoundException {
        return laboService.totalPositiveCases(laboID);
    }

    @GetMapping("/labos/{laboID}/totalNegativeCases")
    public int totalNegativeCases(@PathVariable int laboID) throws LaboNotFoundException {
        return laboService.totalNegativeCases(laboID);
    }

    @GetMapping("/labos/{laboID}/totalCriticalCases")
    public int totalCriticalCases(@PathVariable int laboID) throws LaboNotFoundException {
        return laboService.totalNegativeCases(laboID);
    }

    @GetMapping("/labos/{laboID}/totalDeathCases")
    public int totalDeathCases(@PathVariable int laboID) throws LaboNotFoundException {
        return laboService.totalNegativeCases(laboID);
    }
}
