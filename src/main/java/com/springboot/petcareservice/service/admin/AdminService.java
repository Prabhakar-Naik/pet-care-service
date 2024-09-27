package com.springboot.petcareservice.service.admin;

import com.springboot.petcareservice.dtos.AdminDto;
import com.springboot.petcareservice.model.Admin;
import com.springboot.petcareservice.model.Patient;

import java.util.List;

/**
 * @author prabhakar, @Date 17-09-2024
 */
public interface AdminService {

    Admin getAdminById(Long id);

    Admin getAdminByEmail(String email);

    Admin getAdminByMobile(String mobile);

    List<AdminDto> getAllAdmins();
}
