package com.chicodespons.ambutransport.controller;

import com.chicodespons.ambutransport.dto.CreateTransportDto;
import com.chicodespons.ambutransport.dto.TransportDto;
import com.chicodespons.ambutransport.exceptions.InvalidTeamMemberException;
import com.chicodespons.ambutransport.service.TransportService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(path = "/transport")
public class TransportController {

    private final TransportService transportService;

    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }


    // GetMappings
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransportDto> getAllTransports() {
       return transportService.getAllTransports();
    }

    @GetMapping(path = "/final", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransportDto> getAllFinalTransports(){
        return transportService.getAllFinalTransports();
    }
    //these are final transports because only a final transport gets a missionNumber
    @GetMapping(path = "mission/{missionNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TransportDto getTransportByMissionNumber(@PathVariable Long missionNumber){
        return transportService.getTransportByMissionNumber(missionNumber);
    }


    @GetMapping(path = "intervention/{interventionNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TransportDto getTransportByInterventionNumber(@PathVariable Long interventionNumber){
        return transportService.getTransportByInterventionNumber(interventionNumber);
    }

    @GetMapping(path = "intervention/{interventionDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransportDto> getTransportsByInterventionDate(@PathVariable LocalDate interventionDate){
        return transportService.getTransportByInterventionDate(interventionDate);
    }

    @GetMapping(path = "registration/{registrationDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransportDto> getTransportsByRegistrationDate(@PathVariable LocalDate registrationDate){
        return transportService.getTransportByRegistrationDate(registrationDate);
    }

    @GetMapping(path = "teammember/{teamMemberId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransportDto> getTransportsByTeamMemberId(@PathVariable Long teamMemberId){
        return transportService.getTransportByTeamMemberId(teamMemberId);
    }

    //PostMappings

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CreateTransportDto createTransport(@Valid @RequestBody CreateTransportDto createTransportDto) throws InvalidTeamMemberException {
        return transportService.createTransport(createTransportDto);
    }



}
