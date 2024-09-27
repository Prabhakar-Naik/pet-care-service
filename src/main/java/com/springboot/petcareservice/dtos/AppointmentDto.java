package com.springboot.petcareservice.dtos;

import com.springboot.petcareservice.enums.AppointmentStatus;
import com.springboot.petcareservice.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author prabhakar, @Date 20-09-2024
 */
@Data
public class AppointmentDto {
    private String reason;
    private LocalDate date;
    private LocalTime time;
    private String appointmentNo;
    private LocalDate createdAt;
    private AppointmentStatus status;
    private User patient;
    private User veterinarian;
}
