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

    public Transport() {

    }
}
