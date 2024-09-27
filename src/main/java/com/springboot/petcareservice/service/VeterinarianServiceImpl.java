package com.springboot.petcareservice.service;

import com.springboot.petcareservice.dtos.EntityConverter;
import com.springboot.petcareservice.dtos.PatientDto;
import com.springboot.petcareservice.dtos.VeterinarianDto;
import com.springboot.petcareservice.exceptions.ResourceNotFoundException;
import com.springboot.petcareservice.model.Patient;
import com.springboot.petcareservice.model.Veterinarian;
import com.springboot.petcareservice.repository.VeterinarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author prabhakar, @Date 20-09-2024
 */
@RequiredArgsConstructor
@Service
public class VeterinarianServiceImpl implements VeterinarianService{

    private final VeterinarianRepository veterinarianRepository;
    private final EntityConverter<Veterinarian, VeterinarianDto> entityConverter;


    @Override
    public Veterinarian getVeterinarianById(Long id) {
        return this.veterinarianRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Veterinarian Not Found..!"));
    }

    @Override
    public Veterinarian getVeterinarianByEmail(String email) {
        return this.veterinarianRepository.findByEmail(email).orElseThrow(() ->
                new ResourceNotFoundException("Veterinarian Not Found..!"));
    }

    @Override
    public Veterinarian getVeterinarianByMobile(String mobile) {
        return this.veterinarianRepository.findByPhoneNumber(mobile).orElseThrow(() ->
                new ResourceNotFoundException("Veterinarian Not Found..!"));
    }

    @Override
    public List<VeterinarianDto> getAllVeterinarians() {
        List<Veterinarian> veterinarians = this.veterinarianRepository.findAll();
        return veterinarians.stream()
                .map(veterinarian -> entityConverter.mapEntityToDto(veterinarian, VeterinarianDto.class))
                .collect(Collectors.toList());
    }

}
