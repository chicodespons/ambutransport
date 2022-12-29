package com.chicodespons.ambutransport.model.patient;

import com.chicodespons.ambutransport.model.Transport;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Patient {
    @Id
    @SequenceGenerator(name="patient_seq", sequenceName = "patient_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
    private Long id;
    @OneToMany
    @JoinColumn(name = "patient_id")
    private List<Transport> transports;
    private String firstName;
    private String lastName;
    private String patientIdNumber;
    private String patientIntakeNumber;
    private Gender gender;
    @OneToOne
    private Address address;
}
