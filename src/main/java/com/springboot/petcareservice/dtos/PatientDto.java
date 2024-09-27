package com.springboot.petcareservice.dtos;

import lombok.Data;

/**
 * @author prabhakar, @Date 20-09-2024
 */
@Data
public class PatientDto {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
}
