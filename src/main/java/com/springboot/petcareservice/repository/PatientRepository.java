package com.springboot.petcareservice.repository;

import com.springboot.petcareservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author prabhakar, @Date 17-09-2024
 */
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Optional<Patient> findByEmail(String email);

    Optional<Patient> findByPhoneNumber(String mobile);
}
