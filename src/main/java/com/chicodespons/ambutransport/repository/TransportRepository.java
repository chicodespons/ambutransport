package com.chicodespons.ambutransport.repository;

import com.chicodespons.ambutransport.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransportRepository  extends JpaRepository<Transport, Long> {

    Transport findByMissionNumber(Long missionNumber);

    Transport findByInterventionNumber(Long interventionNumber);

    List<Transport> findAllByInterventionDate(LocalDate interventionDate);

    List<Transport> findAllByRegistrationDate(LocalDate registrationDate);

    List<Transport> findAllByTeamMemberId(Long teamMemberId);
}
