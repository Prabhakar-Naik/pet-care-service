package com.springboot.petcareservice.dtos;

import com.springboot.petcareservice.enums.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;
import lombok.Data;

/**
 * @author prabhakar, @Date 17-09-2024
 */
@Data
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String password;
    private UserType userType;
    private boolean isEnable;
    private String specialization;
}
