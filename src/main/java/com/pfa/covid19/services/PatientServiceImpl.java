package com.pfa.covid19.services;

import com.pfa.covid19.entities.Analyse;
import com.pfa.covid19.entities.Patient;
import com.pfa.covid19.exceptions.PatientNotFoundException;
import com.pfa.covid19.repositories.AnalyseRepository;
import com.pfa.covid19.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PatientServiceImpl implements PatientService{

    private PatientRepository patientRepository;
    private AnalyseRepository analyseRepository;

    @Override
    public List<Patient> listPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

    @Override
    public List<Analyse> listAnalyses(int patientID) {
        List<Analyse> analyses = analyseRepository.findByPatientID(patientID);
        return analyses;
    }

    @Override
    public Patient getPatient(int patientID) throws PatientNotFoundException {
        Patient patient = patientRepository.findById(patientID).orElse(null);
        if(patient==null) throw new PatientNotFoundException("Patient non trouvé");
        return patient;
    }
}
