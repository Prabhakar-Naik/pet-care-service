package com.springboot.petcareservice.model;

import com.springboot.petcareservice.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author prabhakar, @Date 19-09-2024
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reason;
    private LocalDate date;
    private LocalTime time;
    private String appointmentNo;
    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
    @JoinColumn(name = "sender")
    @ManyToOne(fetch = FetchType.LAZY)
    private User patient;
    @JoinColumn(name = "recipient")
    @ManyToOne(fetch = FetchType.LAZY)
    private User veterinarian;

    public void addPatient(User sender){
        this.setPatient(sender);
        if (sender.getAppointments() == null){
            sender.setAppointments(new ArrayList<Appointment>());
        }
        sender.getAppointments().add(this);
    }

    public void addVeterinarian(User recipient){
        this.setVeterinarian(recipient);
        if (recipient.getAppointments() == null){
            recipient.setAppointments(new ArrayList<Appointment>());
        }
        recipient.getAppointments().add(this);
    }

    public void setAppointmentNo(){
        //this.appointmentNo = String.valueOf(new Random()).substring(1,11);
        String randomString = generateRandomString();
        String randomNumber = generateRandomNumber();
        this.appointmentNo = "APP-" + randomNumber + "-" + randomString;
    }

    private static String generateRandomString() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return getString(6, characters);
    }

    private static String generateRandomNumber() {
        String digits = "0123456789";
        return getString(3, digits);
    }

    private static String getString(int length, String digits) {
        StringBuilder randomNumber = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(digits.length());
            randomNumber.append(digits.charAt(index));
        }

        return randomNumber.toString();
    }
}
