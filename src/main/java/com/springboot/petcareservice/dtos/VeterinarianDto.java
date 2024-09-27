package com.springboot.petcareservice.dtos;

import lombok.Data;

/**
 * @author prabhakar, @Date 20-09-2024
 */
@Data
public class VeterinarianDto {
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String password;
    private boolean isEnable;
    private String specialization;
}
