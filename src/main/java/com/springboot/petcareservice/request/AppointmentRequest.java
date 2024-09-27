package com.springboot.petcareservice.request;

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
public class AppointmentRequest {
    private String reason;
    private LocalDate date;
    private LocalTime time;
}