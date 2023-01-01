package com.chicodespons.ambutransport.controller;

import com.chicodespons.ambutransport.dto.CreatePatientDto;
import com.chicodespons.ambutransport.dto.CreateTransportDto;
import com.chicodespons.ambutransport.dto.PatientDto;
import com.chicodespons.ambutransport.exceptions.InvalidTeamMemberException;
import com.chicodespons.ambutransport.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PatientDto> getAllPatients() {
        return patientService.getAllTransports();
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CreatePatientDto createPatient(@Valid @RequestBody CreatePatientDto createPatientDto) {
        return patientService.createPatient(createPatientDto);
    }
}
