package com.springboot.petcareservice.dtos;

import com.springboot.petcareservice.enums.UserType;
import lombok.Data;

/**
 * @author prabhakar, @Date 20-09-2024
 */
@Data
public class AdminDto {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String password;
    private UserType userType;
}
