package com.chicodespons.ambutransport.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
public class UpdateTransportDto {

    private long interventionNumber;
    private LocalDate interventionDate;

    public UpdateTransportDto(long interventionNumber, LocalDate interventionDate) {
        this.interventionNumber = interventionNumber;
        this.interventionDate = interventionDate;
    }


}
