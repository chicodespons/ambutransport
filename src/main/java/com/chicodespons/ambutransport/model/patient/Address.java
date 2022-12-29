package com.chicodespons.ambutransport.model.patient;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @SequenceGenerator(name="address_seq", sequenceName = "address_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    private long id;

    private String streetName;
    private int streetNumber;
    private int postCode;
    private String city;
    private String country;


}
