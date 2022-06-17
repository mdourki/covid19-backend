package com.pfa.covid19.services;

import com.pfa.covid19.entities.Analyse;
import com.pfa.covid19.entities.Region;
import com.pfa.covid19.enums.Result;
import com.pfa.covid19.exceptions.AnalyseNotFoundException;

import java.util.Date;
import java.util.List;

public interface AnalyseService {
    List<Analyse> listAnalyses();
    Analyse getAnalyse(int analyseID) throws AnalyseNotFoundException;
    Result getResult(int analyseID) throws AnalyseNotFoundException;
    Date getDate(int analyseID) throws AnalyseNotFoundException;
}
