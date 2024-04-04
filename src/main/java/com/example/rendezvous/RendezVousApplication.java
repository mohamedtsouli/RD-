package com.example.rendezvous;

import com.example.rendezvous.Repositories.MedecinRepository;
import com.example.rendezvous.Repositories.PatientRepository;
import com.example.rendezvous.Repositories.RendezVousRepository;
import com.example.rendezvous.Service.IHospitalService;
import com.example.rendezvous.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class RendezVousApplication {

    public static void main(String[] args) {
        SpringApplication.run(RendezVousApplication.class, args);
    }

    @Bean
        // annotation bean == execution en demarage
    CommandLineRunner start(
            IHospitalService hospitalService , PatientRepository patientRepository , MedecinRepository medecinRepository , RendezVousRepository rendezVousRepository){

        return args -> {
            Stream.of("moe","meryem","bennis")
                    .forEach(name->{
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("Medecin01","Medecin 02","Medcin 03")
                    .forEach(name->{
                        Medecin medecin = new Medecin();
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        medecin.setEmail(name+"@gmail.com");
                        hospitalService.saveMedecin(medecin);
                    });


            Patient patient1 = patientRepository.findByNom("moe");
            Patient patient  = patientRepository.findById(1L).orElse(null);
            Medecin medecin  = medecinRepository.findByNom("Medecin01");
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            RendezVous saveDRDV =    hospitalService.saveRDV(rendezVous);

            System.out.println(saveDRDV.getId());


            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConcultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("rapport de la consutlation ..");
            hospitalService.saveConsultation(consultation);
        };

    }
}