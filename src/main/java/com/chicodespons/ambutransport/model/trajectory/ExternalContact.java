package com.chicodespons.ambutransport.model.trajectory;

import jakarta.persistence.*;

@Entity
public class ExternalContact {

    @Id
    @SequenceGenerator(name="external_contact_seq", sequenceName = "external_contact_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "external_contact_seq")
    private Long id;

    private String lastName;
    private String firstName;
    private String function;
    private String contactNumber;
    private String hospital;
    private String unit;

    public ExternalContact(String lastName, String firstName, String function, String contactNumber, String hospital, String unit) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.function = function;
        this.contactNumber = contactNumber;
        this.hospital = hospital;
        this.unit = unit;
    }

    public ExternalContact() {
    }
}
