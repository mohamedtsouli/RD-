package com.example.rendezvous.Repositories;

import com.example.rendezvous.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}