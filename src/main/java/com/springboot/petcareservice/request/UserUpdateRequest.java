package com.springboot.petcareservice.request;

import lombok.Data;

/**
 * @author prabhakar, @Date 19-09-2024
 */
@Data
public class UserUpdateRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String specialization;
}
