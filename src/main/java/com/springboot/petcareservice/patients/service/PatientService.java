package com.springboot.petcareservice.patients.service;

import com.springboot.petcareservice.dtos.PatientDto;
import com.springboot.petcareservice.patients.model.Patient;

import java.util.List;

/**
 * @author prabhakar, @Date 17-09-2024
 */
public interface PatientService {

    Patient getPatientById(Long id);

    Patient getPatientByEmail(String email);

    Patient getPatientByMobile(String mobile);

    List<PatientDto> getAllPatients();
}
