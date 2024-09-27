package com.springboot.petcareservice.controller;

import com.springboot.petcareservice.dtos.AdminDto;
import com.springboot.petcareservice.dtos.EntityConverter;
import com.springboot.petcareservice.dtos.PatientDto;
import com.springboot.petcareservice.exceptions.ResourceNotFoundException;
import com.springboot.petcareservice.exceptions.UserNotFoundException;
import com.springboot.petcareservice.model.Admin;
import com.springboot.petcareservice.model.Patient;
import com.springboot.petcareservice.model.User;
import com.springboot.petcareservice.response.ApiResponse;
import com.springboot.petcareservice.service.patient.PatientService;
import com.springboot.petcareservice.utils.FeedBackMessage;
import com.springboot.petcareservice.utils.UrlMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author prabhakar, @Date 17-09-2024
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value = UrlMapping.PATIENTS)
public class PatientController {

    private final PatientService patientService;
    private final EntityConverter<Patient, PatientDto> entityConverter;

    @GetMapping(value = UrlMapping.GET_PATIENT)
    public ResponseEntity<ApiResponse> getPatientById(@PathVariable Long patientId){
        try{
            Patient patient = this.patientService.getPatientById(patientId);
            PatientDto patientDto = this.entityConverter.mapEntityToDto(patient, PatientDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DATA_FOUND,patientDto));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping(value = UrlMapping.GET_PATIENT_BY_MAIL)
    public ResponseEntity<ApiResponse> getPatientByEmail(@RequestParam String email){
        try{
            Patient patient = this.patientService.getPatientByEmail(email);
            PatientDto patientDto = this.entityConverter.mapEntityToDto(patient, PatientDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DATA_FOUND,patientDto));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping(value = UrlMapping.GET_PATIENT_BY_MOBILE)
    public ResponseEntity<ApiResponse> getPatientByMobile(@RequestParam String mobile){
        try{
            Patient patient = this.patientService.getPatientByMobile(mobile);
            PatientDto patientDto = this.entityConverter.mapEntityToDto(patient, PatientDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DATA_FOUND,patientDto));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping(value = UrlMapping.GET_ALL_PATIENTS)
    public ResponseEntity<ApiResponse> getAllPatients(){
        try {
            List<PatientDto> patients = this.patientService.getAllPatients();
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DATA_FOUND,patients));
        }catch (UserNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

}
