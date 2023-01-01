package com.chicodespons.ambutransport.model.patient;

import com.chicodespons.ambutransport.model.Transport;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Patient {
    @Id
    @SequenceGenerator(name="patient_seq", sequenceName = "patient_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
    private long id;
    @OneToMany
    @JoinColumn(name = "patient_id")
    private List<Transport> transports;
    private String firstName;
    private String lastName;


    private String patientIdNumber;
    private String patientIntakeNumber;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @OneToOne
    private Address address;


    public Patient() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient patient)) return false;
        return id == patient.id && Objects.equals(transports, patient.transports) && Objects.equals(firstName, patient.firstName) && Objects.equals(lastName, patient.lastName) && Objects.equals(patientIdNumber, patient.patientIdNumber) && Objects.equals(patientIntakeNumber, patient.patientIntakeNumber) && gender == patient.gender && Objects.equals(address, patient.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transports, firstName, lastName, patientIdNumber, patientIntakeNumber, gender, address);
    }
}
