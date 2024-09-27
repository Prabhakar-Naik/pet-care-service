package com.springboot.petcareservice.service.patient;

import com.springboot.petcareservice.dtos.PatientDto;
import com.springboot.petcareservice.model.Patient;
import org.springframework.stereotype.Service;

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
