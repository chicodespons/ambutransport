package com.chicodespons.ambutransport.model.transportteam;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TeamMember {

    @Id
    @SequenceGenerator(name="team_member_seq", sequenceName = "team_member_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_member_seq")
    private Long id;

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
}
