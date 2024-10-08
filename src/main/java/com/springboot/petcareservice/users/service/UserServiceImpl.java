package com.springboot.petcareservice.users.service;

import com.springboot.petcareservice.dtos.EntityConverter;
import com.springboot.petcareservice.dtos.UserDto;
import com.springboot.petcareservice.exceptions.UserNotFoundException;
import com.springboot.petcareservice.factory.UserFactory;
import com.springboot.petcareservice.users.model.User;
import com.springboot.petcareservice.users.repository.UserRepository;
import com.springboot.petcareservice.request.RegistrationRequest;
import com.springboot.petcareservice.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author prabhakar, @Date 17-09-2024
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserFactory userFactory;
    private final EntityConverter<User, UserDto> entityConverter;

    @Override
    public User addUser(RegistrationRequest request) {
        return this.userFactory.createUser(request);
    }

    @Override
    public User updateUser(Long id, UserUpdateRequest request) {
        User user = this.findByUserId(id);
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setGender(request.getGender());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setSpecialization(request.getSpecialization());
        return this.userRepository.save(user);
    }

//    @Override
//    public User updateUser(Long id, UserUpdateRequest request) {
//        return this.userFactory.updateUser(id,request);
//    }

    @Override
    public User findByUserId(Long userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User Not Found...!"));
    }

    @Override
    public void deleteByUserId(Long userId) {
        this.userRepository.findById(userId)
                .ifPresentOrElse(this.userRepository::delete, () -> {
                    throw new UserNotFoundException("User Not Found");
                });
    }

    @Override
    public List<UserDto> findByUsers() {
        List<User> users = this.userRepository.findAll();
        return users.stream()
                .map(user -> entityConverter.mapEntityToDto(user,UserDto.class))
                .collect(Collectors.toList());
    }


}
