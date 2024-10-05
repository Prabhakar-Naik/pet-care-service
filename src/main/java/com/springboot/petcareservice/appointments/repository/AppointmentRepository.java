package com.springboot.petcareservice.appointments.repository;

import com.springboot.petcareservice.appointments.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author prabhakar, @Date 20-09-2024
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment findByAppointmentNo(String appointmentNo);
}
