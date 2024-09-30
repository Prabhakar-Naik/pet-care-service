package com.springboot.petcareservice.admin.service;

import com.springboot.petcareservice.dtos.AdminDto;
import com.springboot.petcareservice.admin.model.Admin;

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
