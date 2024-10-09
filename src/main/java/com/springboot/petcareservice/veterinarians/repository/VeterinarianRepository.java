package com.springboot.petcareservice.veterinarians.repository;

import com.springboot.petcareservice.veterinarians.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author prabhakar, @Date 17-09-2024
 */
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
    Optional<Veterinarian> findByEmail(String email);

    Optional<Veterinarian> findByPhoneNumber(String mobile);
}
