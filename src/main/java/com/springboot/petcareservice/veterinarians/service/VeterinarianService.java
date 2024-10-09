package com.springboot.petcareservice.veterinarians.service;

import com.springboot.petcareservice.dtos.VeterinarianDto;
import com.springboot.petcareservice.veterinarians.model.Veterinarian;

import java.util.List;

/**
 * @author prabhakar, @Date 17-09-2024
 */
public interface VeterinarianService {

    Veterinarian getVeterinarianById(Long id);

    Veterinarian getVeterinarianByEmail(String email);

    Veterinarian getVeterinarianByMobile(String mobile);

    List<VeterinarianDto> getAllVeterinarians();
}
