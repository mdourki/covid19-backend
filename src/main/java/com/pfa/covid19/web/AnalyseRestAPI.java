package com.pfa.covid19.web;

import com.pfa.covid19.entities.Analyse;

import com.pfa.covid19.enums.Result;
import com.pfa.covid19.exceptions.AnalyseNotFoundException;
import com.pfa.covid19.services.AnalyseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class AnalyseRestAPI {

    private AnalyseService analyseService;

    @GetMapping("/analyses")
    public List<Analyse> listAnalyses() {
        return analyseService.listAnalyses();
    }

    @GetMapping("/analyses/{analyseID}")
    public Analyse getAnalyse(@PathVariable int analyseID) throws AnalyseNotFoundException {
        return analyseService.getAnalyse(analyseID);
    }

    @GetMapping("/analyses/{analyseID}/resultat")
        public Result getResult(@PathVariable int analyseID) throws AnalyseNotFoundException {
        return analyseService.getResult(analyseID);
    }

    @GetMapping("/analyses/{analyseID}/date")
    public Date getDate(@PathVariable int analyseID) throws AnalyseNotFoundException {
        return analyseService.getDate(analyseID);
    }
}
