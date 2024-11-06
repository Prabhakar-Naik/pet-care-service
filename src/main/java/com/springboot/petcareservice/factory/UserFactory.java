package com.springboot.petcareservice.factory;

import com.springboot.petcareservice.users.model.User;
import com.springboot.petcareservice.request.RegistrationRequest;
import com.springboot.petcareservice.request.UserUpdateRequest;

/**
 * @author prabhakar, @Date 17-09-2024
 */
public interface UserFactory {

    public User createUser(RegistrationRequest registrationRequest);

    User updateUser(Long id, UserUpdateRequest request);
}
