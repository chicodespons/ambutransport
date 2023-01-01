package com.chicodespons.ambutransport.repository;

import com.chicodespons.ambutransport.model.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
