package com.example.rendezvous.Repositories;

import com.example.rendezvous.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String name);
}