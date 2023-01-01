package com.chicodespons.ambutransport.mapper;

import com.chicodespons.ambutransport.dto.PatientDto;
import com.chicodespons.ambutransport.model.patient.Patient;
import com.chicodespons.ambutransport.repository.PatientRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientMapper {
    private final PatientRepository patientRepository;

    public PatientMapper(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientDto mapFromPatientToPatientDto(Patient patient){

        return new PatientDto(patient.getId(),
                patient.getTransports(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getPatientIdNumber(),
                patient.getPatientIntakeNumber(),
                patient.getGender(),
                patient.getAddress());
    }

    public List<PatientDto> mapFromPatientToPatientDto(List<Patient> patients){

        return patients.stream()
                .map(this::mapFromPatientToPatientDto)
                .collect(Collectors.toList());
    }


}
