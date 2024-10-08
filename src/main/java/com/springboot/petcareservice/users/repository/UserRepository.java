package com.springboot.petcareservice.users.repository;

import com.springboot.petcareservice.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author prabhakar, @Date 17-09-2024
 */
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
}
