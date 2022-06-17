package com.pfa.covid19.services;

import com.pfa.covid19.entities.Patient;
import com.pfa.covid19.entities.Analyse;
import com.pfa.covid19.exceptions.PatientNotFoundException;

import java.util.List;

public interface PatientService {
    List<Patient> listPatients();
    List<Analyse> listAnalyses(int patientID);
    Patient getPatient(int patientID) throws PatientNotFoundException;
}
