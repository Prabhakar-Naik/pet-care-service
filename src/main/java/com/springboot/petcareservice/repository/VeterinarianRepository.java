package com.springboot.petcareservice.repository;

import com.springboot.petcareservice.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author prabhakar, @Date 17-09-2024
 */
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
    Optional<Veterinarian> findByEmail(String email);

    Optional<Veterinarian> findByPhoneNumber(String mobile);
}
