package com.springboot.petcareservice.service.patient;

import com.springboot.petcareservice.dtos.EntityConverter;
import com.springboot.petcareservice.dtos.PatientDto;
import com.springboot.petcareservice.dtos.UserDto;
import com.springboot.petcareservice.exceptions.ResourceNotFoundException;
import com.springboot.petcareservice.model.Patient;
import com.springboot.petcareservice.repository.PatientRepository;
import com.springboot.petcareservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author prabhakar, @Date 20-09-2024
 */
@RequiredArgsConstructor
@Service
public class PatientServiceImpl implements PatientService{

    //private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final EntityConverter<Patient,PatientDto> entityConverter;

    @Override
    public Patient getPatientById(Long id) {
        return this.patientRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Patient Not Found..!"));
    }

    @Override
    public Patient getPatientByEmail(String email) {
        return this.patientRepository.findByEmail(email).orElseThrow(() ->
                new ResourceNotFoundException("Patient Not Found..! with: "+email));
    }

    @Override
    public Patient getPatientByMobile(String mobile) {
        return this.patientRepository.findByPhoneNumber(mobile).orElseThrow(() ->
                new ResourceNotFoundException("Patient Not Found..! with: "+mobile));
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = this.patientRepository.findAll();
        return patients.stream()
                .map(patient -> entityConverter.mapEntityToDto(patient, PatientDto.class))
                .collect(Collectors.toList());
    }


}
