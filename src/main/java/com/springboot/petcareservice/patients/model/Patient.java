package com.springboot.petcareservice.patients.model;

import com.springboot.petcareservice.users.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author prabhakar, @Date 17-09-2024
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "patient_id")
public class Patient extends User {
    private long id;
}
