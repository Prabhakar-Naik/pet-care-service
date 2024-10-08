package com.springboot.petcareservice.users.model;

import com.springboot.petcareservice.appointments.model.Appointment;
import com.springboot.petcareservice.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author prabhakar, @Date 17-09-2024
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    @Column(name = "mobile")
    private String phoneNumber;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private boolean isEnable;

    @Transient
    private String specialization;

    @Transient
    private List<Appointment> appointments;
}
