package com.chicodespons.ambutransport.dto;

import com.chicodespons.ambutransport.model.Transport;
import com.chicodespons.ambutransport.model.patient.Address;
import com.chicodespons.ambutransport.model.patient.Gender;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
@Getter
@Setter
@EqualsAndHashCode
public class PatientDto {

    private long id;
    private List<Transport> transports;
    private String firstName;
    private String lastName;
    private String patientIdNumber;
    private String patientIntakeNumber;
    private Gender gender;
    private Address address;

    public PatientDto(long id, List<Transport> transports, String firstName, String lastName, String patientIdNumber, String patientIntakeNumber, Gender gender, Address address) {
        this.id = id;
        this.transports = transports;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientIdNumber = patientIdNumber;
        this.patientIntakeNumber = patientIntakeNumber;
        this.gender = gender;
        this.address = address;
    }


}
