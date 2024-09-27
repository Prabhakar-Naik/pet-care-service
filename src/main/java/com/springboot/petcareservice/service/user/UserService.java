package com.springboot.petcareservice.service.user;

import com.springboot.petcareservice.dtos.UserDto;
import com.springboot.petcareservice.model.User;
import com.springboot.petcareservice.request.RegistrationRequest;
import com.springboot.petcareservice.request.UserUpdateRequest;

import java.util.List;

/**
 * @author prabhakar, @Date 19-09-2024
 */
public interface UserService {

    User addUser(RegistrationRequest request);

    User updateUser(Long id, UserUpdateRequest request);

    User findByUserId(Long userId);

    void deleteByUserId(Long userId);

    List<UserDto> findByUsers();


}
