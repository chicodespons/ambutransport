package com.chicodespons.ambutransport.dto;

import com.chicodespons.ambutransport.model.patient.Address;
import com.chicodespons.ambutransport.model.patient.Gender;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CreatePatientDto {
    @NotNull
    @Min(1)
    private long transportId;
    @NotNull
    @NotEmpty
    @NotBlank
    private String firstName;
    @NotNull
    @NotEmpty
    @NotBlank
    private String lastName;
    @NotNull
    @NotEmpty
    @NotBlank
    private String patientIdNumber;
    @NotNull
    @NotEmpty
    @NotBlank
    private String patientIntakeNumber;
    @NotNull
    @NotEmpty
    @NotBlank
    private Gender gender;
    @NotNull
    private AddressDto address;

    public CreatePatientDto(long transportId, String firstName, String lastName, String patientIdNumber, String patientIntakeNumber, Gender gender, AddressDto address) {
        this.transportId = transportId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientIdNumber = patientIdNumber;
        this.patientIntakeNumber = patientIntakeNumber;
        this.gender = gender;
        this.address = address;
    }
}
