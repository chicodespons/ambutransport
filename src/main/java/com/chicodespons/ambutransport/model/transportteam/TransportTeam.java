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
    @JoinColumn(name = "transport_organizer_id")
    private TeamMember transportOrganizer;
    @ManyToOne
    @JoinColumn(name = "patient_responsible_id")
    private TeamMember patientResponsible;
    @ManyToOne
    @JoinColumn(name = "ambulance_driver_id")
    private TeamMember ambulanceDriver;
    private String expert;
    private String additionalPeople;
    private String partner;


}
