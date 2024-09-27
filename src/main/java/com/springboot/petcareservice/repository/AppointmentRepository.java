package com.springboot.petcareservice.repository;

import com.springboot.petcareservice.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author prabhakar, @Date 20-09-2024
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment findByAppointmentNo(String appointmentNo);
}
