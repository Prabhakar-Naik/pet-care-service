package com.springboot.petcareservice.repository;

import com.springboot.petcareservice.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author prabhakar, @Date 17-09-2024
 */
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);

    Optional<Admin> findByPhoneNumber(String mobile);
}
