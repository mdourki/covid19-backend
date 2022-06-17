package com.pfa.covid19.web;

import com.pfa.covid19.entities.Labo;
import com.pfa.covid19.entities.Ville;
import com.pfa.covid19.exceptions.VilleNotFoundException;
import com.pfa.covid19.services.VilleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class VilleRestAPI {
    private VilleService villeService;

    @GetMapping("/villes")
    public List<Ville> listVilles() {
        return villeService.listVilles();
    }

    @GetMapping("/villes/{villeId}")
    public Ville getVille(@PathVariable int villeId) throws VilleNotFoundException {
        return villeService.getVille(villeId);
    }

    @GetMapping("/villes/{villeId}/labos")
    public List<Labo> listLabos(@PathVariable int villeId) {
        return villeService.listLabos(villeId);
    }

    @GetMapping("/villes/{villeId}/totalPositiveCases")
    public int totalPositiveCases(@PathVariable int villeId) {
        return villeService.totalPositiveCases(villeId);
    }

    @GetMapping("/villes/{villeId}/totalNegativeCases")
    public int totalNegativeCases(@PathVariable int villeId) {
        return villeService.totalNegativeCases(villeId);
    }

    @GetMapping("/villes/{villeId}/totalCriticalCases")
    public int totalCriticalCases(@PathVariable int villeId) {
        return villeService.totalCriticalCases(villeId);
    }

    @GetMapping("/villes/{villeId}/totalDeathCases")
    public int totalDeathCases(@PathVariable int villeId) {
        return villeService.totalDeathCases(villeId);
    }
}
