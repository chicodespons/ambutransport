package com.chicodespons.ambutransport.model.transportteam;

import com.chicodespons.ambutransport.model.Transport;
import jakarta.persistence.*;

@Entity
public class TransportTeam {

    @Id
    @SequenceGenerator(name="transport_team_seq", sequenceName = "transport_team_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transport_team_seq")
    private Long id;
    @OneToOne
    private Transport transport;
    @ManyToOne
    private TeamMember transportOrganizer;
    @ManyToOne
    private TeamMember patientResponsible;
    @ManyToOne
    private TeamMember ambulanceDriver;
    private String expert;
    private String additionalPeople;
    private String partner;


}
