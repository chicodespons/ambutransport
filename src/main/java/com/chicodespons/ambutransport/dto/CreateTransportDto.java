package com.chicodespons.ambutransport.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;
@Getter
public class CreateTransportDto {

    private Long interventionNumber;
    private LocalDate interventionDate;
    private LocalDate registrationDate;
    @NotNull
    @NotEmpty
    private Long teamMemberId;

    public CreateTransportDto(Long interventionNumber, LocalDate interventionDate, Long teamMemberId) {
        this.interventionNumber = interventionNumber;
        this.interventionDate = interventionDate;
        this.registrationDate = LocalDate.now();
        this.teamMemberId = teamMemberId;
    }
}
