package com.chicodespons.ambutransport.mapper;

import com.chicodespons.ambutransport.dto.CreateTransportDto;
import com.chicodespons.ambutransport.dto.TransportDto;
import com.chicodespons.ambutransport.exceptions.InvalidTeamMember;
import com.chicodespons.ambutransport.model.Transport;
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

    public Transport mapCreateTransportDtotoTransport(CreateTransportDto CreateTransportDto) throws InvalidTeamMember {
        Transport transport = new Transport();
               transport.setInterventionNumber(CreateTransportDto.getInterventionNumber());
               transport.setInterventionDate(CreateTransportDto.getInterventionDate());
               transport.setRegistrationDate(CreateTransportDto.getRegistrationDate());
               transport.setTeamMember(teamMemberRepository.findById(CreateTransportDto.getTeamMemberId())
                       .orElseThrow(()->new InvalidTeamMember("No valid team member has been given")));

               return transport;
    }

    public List<TransportDto> mapTranportToTransportDto(List<Transport> transports) {

         return transports.stream()
                 .map(transport -> mapTransportToTransportDto(transport))
                 .collect(Collectors.toList());
    }

    public TransportDto mapTransportToTransportDto(Transport transport){
        return new TransportDto(
                transport.getId(),
                transport.getMissionNumber(),
                transport.getInterventionNumber(),
                transport.getInterventionDate(),
                transport.getRegistrationDate(),
                transport.getTeamMember());

    }
}
