package com.chicodespons.ambutransport.model.healthcondition;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class VitalParameters {

    @Id
    @SequenceGenerator(name="vital_parameters_seq", sequenceName = "vital_parameters_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vital_parameters_seq")
    private Long id;
    private LocalDateTime timeOfEvaluation;
    private int pulse;
    private String saturation;
    private int respitoryRate;
    private String bloodPressure;
    private double temperature;
    private String glycemie;
    private double etCO2;

}
