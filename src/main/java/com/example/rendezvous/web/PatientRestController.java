package com.example.rendezvous.web;

import com.example.rendezvous.Repositories.PatientRepository;
import com.example.rendezvous.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> patientList(){
        return  patientRepository.findAll();
    }
}