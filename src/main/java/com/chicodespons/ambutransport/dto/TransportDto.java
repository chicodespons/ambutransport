package com.chicodespons.ambutransport.dto;

import com.chicodespons.ambutransport.model.transportteam.TeamMember;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class TransportDto {

    private Long id;
    private Long missionNumber;
    private Long interventionNumber;
    private LocalDate interventionDate;
    private LocalDate registrationDate;
    private TeamMember teamMember;

    public TransportDto(Long id, Long missionNumber, Long interventionNumber, LocalDate interventionDate, LocalDate registrationDate, TeamMember teamMember) {
        this.id = id;
        this.missionNumber = missionNumber;
        this.interventionNumber = interventionNumber;
        this.interventionDate = interventionDate;
        this.registrationDate = registrationDate;
        this.teamMember = teamMember;
    }
}
