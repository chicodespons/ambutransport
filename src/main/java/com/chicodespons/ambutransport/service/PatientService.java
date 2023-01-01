package com.chicodespons.ambutransport.service;

import com.chicodespons.ambutransport.dto.CreatePatientDto;
import com.chicodespons.ambutransport.dto.PatientDto;
import com.chicodespons.ambutransport.mapper.PatientMapper;
import com.chicodespons.ambutransport.model.patient.Patient;
import com.chicodespons.ambutransport.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    public List<PatientDto> getAllTransports() {
        List<Patient> patients = patientRepository.findAll();
        return patientMapper.mapFromPatientToPatientDto(patients);
    }


    public CreatePatientDto createPatient(CreatePatientDto createPatientDto) {
        return null;
    }
}
