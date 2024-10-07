package com.springboot.petcareservice.factory;

import com.springboot.petcareservice.patients.model.Patient;
import com.springboot.petcareservice.model.User;
import com.springboot.petcareservice.patients.repository.PatientRepository;
import com.springboot.petcareservice.repository.UserRepository;
import com.springboot.petcareservice.request.RegistrationRequest;
import com.springboot.petcareservice.request.UserUpdateRequest;
import com.springboot.petcareservice.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.springboot.petcareservice.factory.AdminFactory.getUser;

/**
 * @author prabhakar, @Date 17-09-2024
 */
@Service
@RequiredArgsConstructor
public class PatientFactory {
    private final UserAttributesMapper userAttributesMapper;
    private final UserRepository userRepository;
    private final PatientRepository patientRepository;

    public User createPatient(RegistrationRequest request) {
        Patient patient = new Patient();
        userAttributesMapper.setCommonAttributes(request,patient);
        //patient.setSpecialization(request.getSpecialization());
        return this.patientRepository.save(patient);
    }

    public User updatePatient(long id, UserUpdateRequest request) {
        return getUser(id, request, this.userRepository);
    }
}
