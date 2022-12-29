package com.chicodespons.ambutransport.model.healthcondition;

import jakarta.persistence.*;

@Entity
public class Medication {

    @Id
    @SequenceGenerator(name="medication_seq", sequenceName = "medication_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medication_seq")
    private Long id;

    private String name;
}
