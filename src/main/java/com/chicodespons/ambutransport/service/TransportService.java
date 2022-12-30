package com.chicodespons.ambutransport.service;

import com.chicodespons.ambutransport.dto.CreateTransportDto;
import com.chicodespons.ambutransport.dto.TransportDto;
import com.chicodespons.ambutransport.dto.UpdateTransportDto;
import com.chicodespons.ambutransport.exceptions.InvalidTeamMemberException;
import com.chicodespons.ambutransport.exceptions.UnvalidTransportIdException;
import com.chicodespons.ambutransport.mapper.TransportMapper;
import com.chicodespons.ambutransport.model.Transport;
import com.chicodespons.ambutransport.repository.TransportRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransportService {

    private final TransportRepository transportRepository;
    private final TransportMapper transportMapper;

    public TransportService(TransportRepository transportRepository, TransportMapper transportMapper) {
        this.transportRepository = transportRepository;
        this.transportMapper = transportMapper;
    }

    public List<TransportDto> getAllTransports() {

        List<Transport> transports = transportRepository.findAll();
        return transportMapper.mapTranportToTransportDto(transports);

    }

    public List<TransportDto> getAllFinalTransports() {

        List<Transport> transports = transportRepository.findAll().stream()
                .filter(transport -> transport.getMissionNumber() != 0)
                .toList();
        return transportMapper.mapTranportToTransportDto(transports);
    }

    public TransportDto getTransportByMissionNumber(Long missionNumber) {

        Transport transport = transportRepository.findByMissionNumber(missionNumber);
        return transportMapper.mapTransportToTransportDto(transport);
    }

    public TransportDto getTransportByInterventionNumber(Long interventionNumber) {

        Transport transport = transportRepository.findByInterventionNumber(interventionNumber);
        return transportMapper.mapTransportToTransportDto(transport);
    }

    public List<TransportDto> getTransportByInterventionDate(LocalDate interventionDate) {

        List<Transport> transports = transportRepository.findAllByInterventionDate(interventionDate);
        return transportMapper.mapTranportToTransportDto(transports);

    }

    public List<TransportDto> getTransportByRegistrationDate(LocalDate registrationDate) {

        List<Transport> transports = transportRepository.findAllByRegistrationDate(registrationDate);
        return transportMapper.mapTranportToTransportDto(transports);
    }

    public List<TransportDto> getTransportByTeamMemberId(Long teamMemberId) {

        List<Transport> transports = transportRepository.findAllByTeamMemberId(teamMemberId);
        return transportMapper.mapTranportToTransportDto(transports);
    }


    public CreateTransportDto createTransport(CreateTransportDto createTransportDto) throws InvalidTeamMemberException {
        Transport transport = transportMapper.mapCreateTransportDtotoTransport(createTransportDto);
        transportRepository.save(transport);
        return createTransportDto;
    }

    public UpdateTransportDto updateTransport(long id, UpdateTransportDto updateTransportDto) throws UnvalidTransportIdException {

        Transport transport = transportRepository.findById(id).orElseThrow(()-> new UnvalidTransportIdException("Transport for given id is not found"));
        transport.setInterventionNumber(updateTransportDto.getInterventionNumber());
        if(updateTransportDto.getInterventionDate() != null){
            transport.setInterventionDate(updateTransportDto.getInterventionDate());
        }

        transportRepository.save(transport);
        return updateTransportDto;

    }

}
