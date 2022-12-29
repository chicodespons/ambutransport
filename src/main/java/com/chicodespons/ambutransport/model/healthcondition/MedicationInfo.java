package com.chicodespons.ambutransport.model.healthcondition;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class MedicationInfo {

    @Id
    @SequenceGenerator(name="medication_info_seq", sequenceName = "medication_info_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medication_info_seq")
    private Long id;
    @ManyToOne
    private Medication medication;
    private String dose;
    private Route route;
    private LocalDateTime timeOfAdministation;
    private String administrator;

}
