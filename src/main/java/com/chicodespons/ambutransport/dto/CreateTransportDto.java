package com.chicodespons.ambutransport.dto;

import lombok.Getter;

import java.time.LocalDate;
@Getter
public class CreateTransportDto {

    private long interventionNumber;
    private LocalDate interventionDate;
    private LocalDate registrationDate;
    private long teamMemberId;

    public CreateTransportDto(long interventionNumber, LocalDate interventionDate, LocalDate registrationDate, long teamMemberId) {
        this.interventionNumber = interventionNumber;
        this.interventionDate = interventionDate;
        this.registrationDate = registrationDate;
        this.teamMemberId = teamMemberId;
    }
}
