package com.chicodespons.ambutransport.model.transportteam;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class TeamMember {

    @Id
    @SequenceGenerator(name="team_member_seq", sequenceName = "team_member_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_member_seq")
    private long id;

    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(value = EnumType.STRING)
    @ElementCollection
    private List<TeamMemberRole> teamMemberRoles;

    public TeamMember(String firstName, String lastName, String email, List<TeamMemberRole> teamMemberRoles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.teamMemberRoles = teamMemberRoles;
    }

    public TeamMember() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TeamMemberRole> getTeamMemberRoles() {
        return teamMemberRoles;
    }

    public void setTeamMemberRoles(List<TeamMemberRole> teamMemberRoles) {
        this.teamMemberRoles = teamMemberRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamMember that)) return false;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && Objects.equals(teamMemberRoles, that.teamMemberRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, teamMemberRoles);
    }
}
