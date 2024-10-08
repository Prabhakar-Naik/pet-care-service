package com.springboot.petcareservice.users.service;

import com.springboot.petcareservice.users.model.User;
import com.springboot.petcareservice.request.RegistrationRequest;
import org.springframework.stereotype.Service;

/**
 * @author prabhakar, @Date 17-09-2024
 */
@Service
public class UserAttributesMapper {

    public void setCommonAttributes(RegistrationRequest source, User target){
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setGender(source.getGender());
        target.setPhoneNumber(source.getPhoneNumber());
        target.setEmail(source.getEmail());
        target.setPassword(source.getPassword());
        target.setUserType(source.getUserType());
        target.setEnable(source.isEnable());
    }


}
