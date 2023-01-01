package com.chicodespons.ambutransport.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@EqualsAndHashCode
public class CreateTransportDto {

    private long interventionNumber;

    private LocalDate interventionDate;
    private LocalDate registrationDate;
    @NotNull
    @Min(value = 1)
    private long teamMemberId;

    public CreateTransportDto(long interventionNumber, LocalDate interventionDate, long teamMemberId) {
        this.interventionNumber = interventionNumber;
        this.interventionDate = interventionDate;
        this.registrationDate = LocalDate.now();
        this.teamMemberId = teamMemberId;
    }
}
