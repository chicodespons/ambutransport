package com.chicodespons.ambutransport.model.transportassessment;

import com.chicodespons.ambutransport.model.Transport;
import jakarta.persistence.*;

@Entity
public class TransportAssessment {

    @Id
    @SequenceGenerator(name="transport_assessment_seq", sequenceName = "transport_assessment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transport_assessment_seq")
    private Long id;
    @OneToOne
    private Transport transport;
    private int artificialAirway;
    private int respitoryRate;
    private int hemodynamicState;
    private int heartRhythm;
    private int neurlogicalState;
    private int cardialMonitoring;
    private int ivAccess;
    private int pacemaker;
    private int pharmacoOrExtraCor;
    private int totalScore;


}
