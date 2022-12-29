package com.chicodespons.ambutransport.model.trajectory;

import com.chicodespons.ambutransport.model.Transport;
import jakarta.persistence.*;


@Entity
public class Trajectory {
    @Id
    @SequenceGenerator(name="trajectory_seq", sequenceName = "trajectory_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trajectory_seq")
    private Long id;

    @OneToOne
    private Transport transport;
    @ManyToOne
    private ExternalContact referrer;
    @ManyToOne
    private ExternalContact receiver;
    @Enumerated(EnumType.STRING)
    private Direction direction;
    @Enumerated(EnumType.STRING)
    private TypeOfTransport typeOfTransport;
    @Enumerated(EnumType.STRING)
    private KlinicalRationale klinicalRationale;
    @Enumerated(EnumType.STRING)
    private NonKlinicalRationale nonKlinicalRationale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
