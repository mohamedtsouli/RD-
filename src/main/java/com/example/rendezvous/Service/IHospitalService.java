package com.example.rendezvous.Service;

import com.example.rendezvous.entities.Consultation;
import com.example.rendezvous.entities.Medecin;
import com.example.rendezvous.entities.Patient;
import com.example.rendezvous.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
