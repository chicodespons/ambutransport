package com.chicodespons.ambutransport.model;

import com.chicodespons.ambutransport.model.trajectory.Trajectory;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Transport {
    @Id
    @SequenceGenerator(name="transport_seq", sequenceName = "transport_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transport_seq")
    private long missionNumber;
    private long interventionNumber;
    private LocalDate interventionDate;
    private LocalDate registrationDate;
    @OneToOne
    private Trajectory trajectory;
    private TransportTeam transportTeam;
    private Patient patient;
    private TransportAssessment transportAssessment;
    private HealthCondition healthCondition;

    public Transport(long interventionNumber, LocalDate interventionDate, Trajectory trajectory, TransportTeam transportTeam, Patient patient, TransportAssessment transportAssessment, HealthCondition healthCondition) {
        this.interventionNumber = interventionNumber;
        this.interventionDate = interventionDate;
        this.registrationDate = LocalDate.now();
        this.trajectory = trajectory;
        this.transportTeam = transportTeam;
        this.patient = patient;
        this.transportAssessment = transportAssessment;
        this.healthCondition = healthCondition;
    }

    public Transport() {

    }
}
