package com.springboot.petcareservice.factory;

import com.springboot.petcareservice.exceptions.UserAlreadyExistsException;
import com.springboot.petcareservice.exceptions.UserNotFoundException;
import com.springboot.petcareservice.model.User;
import com.springboot.petcareservice.repository.UserRepository;
import com.springboot.petcareservice.request.RegistrationRequest;
import com.springboot.petcareservice.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author prabhakar, @Date 17-09-2024
 */
@Component
@RequiredArgsConstructor
public class SimpleUserFactory implements UserFactory{

    private final UserRepository userRepository;
    private final AdminFactory adminFactory;
    private final PatientFactory patientFactory;
    private final VeterinarianFactory veterinarianFactory;


    @Override
    public User createUser(RegistrationRequest request) {
        if (userRepository.existsByEmail(request.getEmail())){
            throw new  UserAlreadyExistsException("OOPS! "+request.getEmail()+" already exists.");
        }

        switch (request.getUserType()){
            case VET -> {
                return this.veterinarianFactory.createVeterinarian(request);
            }
            case PATIENT -> {
                return patientFactory.createPatient(request);
            }
            case ADMIN -> {
                return this.adminFactory.createAdmin(request);
            }
            default -> {
                return null;
            }
        }

    }

    @Override
    public User updateUser(Long id, UserUpdateRequest request) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("OOPS! User Not exists.");
        }else {
            switch (user.get().getUserType()) {
                case VET -> {
                    return this.veterinarianFactory.updateVeterinarian(user.get().getId(),request);
                }
                case PATIENT -> {
                    return patientFactory.updatePatient(user.get().getId(), request);
                }
                case ADMIN -> {
                    return this.adminFactory.updateAdmin(user.get().getId(),request);
                }
                default -> {
                    return null;
                }
            }
        }
    }


}
