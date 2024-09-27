package com.springboot.petcareservice.factory;

import com.springboot.petcareservice.model.User;
import com.springboot.petcareservice.model.Veterinarian;
import com.springboot.petcareservice.repository.UserRepository;
import com.springboot.petcareservice.repository.VeterinarianRepository;
import com.springboot.petcareservice.request.RegistrationRequest;
import com.springboot.petcareservice.request.UserUpdateRequest;
import com.springboot.petcareservice.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.springboot.petcareservice.factory.AdminFactory.getUser;

/**
 * @author prabhakar, @Date 17-09-2024
 */
@Service
@RequiredArgsConstructor
public class VeterinarianFactory {

    private final VeterinarianRepository veterinarianRepository;
    private final UserRepository userRepository;
    private final UserAttributesMapper userAttributesMapper;

    public User createVeterinarian(RegistrationRequest request) {
        Veterinarian veterinarian = new Veterinarian();
        userAttributesMapper.setCommonAttributes(request,veterinarian);
        veterinarian.setSpecialization(request.getSpecialization());

        return this.veterinarianRepository.save(veterinarian);
    }

    public User updateVeterinarian(Long id, UserUpdateRequest request){
        return getUser(id, request, this.userRepository);
    }
}