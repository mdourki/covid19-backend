package com.pfa.covid19.services;

import com.pfa.covid19.entities.Analyse;
import com.pfa.covid19.enums.Result;
import com.pfa.covid19.exceptions.AnalyseNotFoundException;
import com.pfa.covid19.repositories.AnalyseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AnalyseServiceImpl implements AnalyseService {

    private AnalyseRepository analyseRepository;

    @Override
    public List<Analyse> listAnalyses() {
        List<Analyse> analyses = analyseRepository.findAll();
        return analyses;
    }

    @Override
    public Analyse getAnalyse(int analyseID) throws AnalyseNotFoundException {
        Analyse analyse = analyseRepository.findById(analyseID).orElse(null);
        if(analyse==null) throw new AnalyseNotFoundException("Analyse non trouvée");
        return analyse;
    }

    @Override
    public Result getResult(int analyseID) throws AnalyseNotFoundException {
        Analyse analyse = getAnalyse(analyseID);
        return analyse.getResult();
    }

    @Override
    public Date getDate(int analyseID) throws AnalyseNotFoundException {
        Analyse analyse = getAnalyse(analyseID);
        return analyse.getDate();
    }
}
