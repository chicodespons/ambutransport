package com.chicodespons.ambutransport.model.healthcondition;

import com.chicodespons.ambutransport.model.Transport;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class HealthCondition {

    @Id
    @SequenceGenerator(name="health_condition_seq", sequenceName = "health_condition_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "health_condition_seq")
    private Long id;
    @ManyToOne
    private Transport transport;
    private String airway;
    private String breathing;
    private String circulation;
    private String disability;
    private String exposure;
    @OneToMany
    private List<MedicationInfo> medicationInfoList;
    @OneToMany
    private List<VitalParameters> vitalParametersList;
    private String extraInfo;
    private LocalDate timeOfCreation;
    private LocalDate timeOfEvaluation;
    @Enumerated(value = EnumType.STRING)
    private Period period;

}
