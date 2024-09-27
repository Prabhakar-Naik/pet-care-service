package com.springboot.petcareservice.factory;

import com.springboot.petcareservice.model.Admin;
import com.springboot.petcareservice.model.Patient;
import com.springboot.petcareservice.model.User;
import com.springboot.petcareservice.repository.AdminRepository;
import com.springboot.petcareservice.repository.UserRepository;
import com.springboot.petcareservice.request.RegistrationRequest;
import com.springboot.petcareservice.request.UserUpdateRequest;
import com.springboot.petcareservice.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author prabhakar, @Date 17-09-2024
 */
@Service
@RequiredArgsConstructor
public class AdminFactory {

    private final UserAttributesMapper userAttributesMapper;
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    public User createAdmin(RegistrationRequest request) {
        Admin admin = new Admin();
        userAttributesMapper.setCommonAttributes(request,admin);
        //admin.setSpecialization(request.getSpecialization());
        return this.adminRepository.save(admin);
    }

    public User updateAdmin(long id, UserUpdateRequest request) {
        return getUser(id, request, this.userRepository);
    }

    @NotNull
    static User getUser(long id, UserUpdateRequest request, UserRepository userRepository) {
        Optional<User> user = userRepository.findById(id);
        user.get().setFirstName(request.getFirstName());
        user.get().setLastName(request.getLastName());
        user.get().setGender(request.getGender());
        user.get().setPhoneNumber(request.getPhoneNumber());
        user.get().setSpecialization(request.getSpecialization());
        return userRepository.save(user.get());
    }
}
