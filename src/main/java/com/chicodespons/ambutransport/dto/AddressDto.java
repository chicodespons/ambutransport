package com.chicodespons.ambutransport.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AddressDto {
    @NotNull
    @NotEmpty
    @NotBlank
    private String streetName;

    @Min(value = 1)
    @NotNull
    private int streetNumber;
    @Min(value = 1000)
    @NotNull
    private int postCode;
    @NotNull
    @NotEmpty
    @NotBlank
    private String country;

    public AddressDto(String streetName, int streetNumber, int postCode, String country) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.country = country;
    }
}
