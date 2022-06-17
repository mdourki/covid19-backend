package com.pfa.covid19.web;

import com.pfa.covid19.entities.Analyse;
import com.pfa.covid19.entities.Patient;
import com.pfa.covid19.exceptions.PatientNotFoundException;
import com.pfa.covid19.services.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class PatientRestAPI {
    private PatientService patientService;

    @GetMapping("/patients/{patientId}")
    public Patient getPatient(@PathVariable int patientId) throws PatientNotFoundException {
        return patientService.getPatient(patientId);
    }

    @GetMapping("/patients")
    public List<Patient> listPatients() {
        return patientService.listPatients();
    }

    @GetMapping("/patients/{patientId}/analyses")
    public List<Analyse> listAnalyses(@PathVariable int patientId) {
        return patientService.listAnalyses(patientId);
    }
}
