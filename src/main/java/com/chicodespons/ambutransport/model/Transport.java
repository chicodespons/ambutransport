package com.chicodespons.ambutransport.model;

import com.chicodespons.ambutransport.model.trajectory.Trajectory;
import com.chicodespons.ambutransport.model.transportteam.TeamMember;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
public class Transport {
    @Id
    @SequenceGenerator(name="transport_seq", sequenceName = "transport_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transport_seq")
    private long id;
    private long missionNumber;
    private long interventionNumber;
    private LocalDate interventionDate;
    private LocalDate registrationDate;
    @ManyToOne
    @JoinColumn(name = "team_member_id")
    private TeamMember teamMember;

    public Transport() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMissionNumber() {
        return missionNumber;
    }

    public void setMissionNumber(long missionNumber) {
        this.missionNumber = missionNumber;
    }

    public long getInterventionNumber() {
        return interventionNumber;
    }

    public void setInterventionNumber(long interventionNumber) {
        this.interventionNumber = interventionNumber;
    }

    public LocalDate getInterventionDate() {
        return interventionDate;
    }

    public void setInterventionDate(LocalDate interventionDate) {
        this.interventionDate = interventionDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
    }
}
