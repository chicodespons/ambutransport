package com.chicodespons.ambutransport.model.patient;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
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

    public Address() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return id == address.id && streetNumber == address.streetNumber && postCode == address.postCode && Objects.equals(streetName, address.streetName) && Objects.equals(city, address.city) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, streetName, streetNumber, postCode, city, country);
    }
}
