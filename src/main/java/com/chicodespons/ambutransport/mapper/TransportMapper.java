package com.chicodespons.ambutransport.mapper;

import com.chicodespons.ambutransport.dto.CreateTransportDto;
import com.chicodespons.ambutransport.dto.TransportDto;
import com.chicodespons.ambutransport.exceptions.InvalidTeamMemberException;
import com.chicodespons.ambutransport.model.Transport;
import com.chicodespons.ambutransport.model.transportteam.TeamMember;
import com.chicodespons.ambutransport.repository.TeamMemberRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransportMapper {

    private final TeamMemberRepository teamMemberRepository;

    public TransportMapper(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    public Transport mapCreateTransportDtotoTransport(CreateTransportDto createTransportDto) throws InvalidTeamMemberException {
        Transport transport = new Transport();

        if (createTransportDto.getInterventionDate()!=null){
            transport.setInterventionDate(createTransportDto.getInterventionDate());
        }
        transport.setInterventionNumber(createTransportDto.getInterventionNumber());
        transport.setRegistrationDate(createTransportDto.getRegistrationDate());
        transport.setTeamMember(teamMemberRepository.findById(createTransportDto.getTeamMemberId())
                       .orElseThrow(()->new InvalidTeamMemberException("No valid team member has been given")));

        return transport;
    }

    public List<TransportDto> mapTranportToTransportDto(List<Transport> transports) {

         return transports.stream()
                 .map(this::mapTransportToTransportDto)
                 .collect(Collectors.toList());
    }

    public TransportDto mapTransportToTransportDto(Transport transport){
        TeamMember teamMember = transport.getTeamMember();

        return new TransportDto(
                transport.getId(),
                transport.getMissionNumber(),
                transport.getInterventionNumber(),
                transport.getInterventionDate(),
                transport.getRegistrationDate(),
                teamMember);

    }
}
