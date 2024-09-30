package com.springboot.petcareservice.admin.service;

import com.springboot.petcareservice.dtos.AdminDto;
import com.springboot.petcareservice.dtos.EntityConverter;
import com.springboot.petcareservice.exceptions.ResourceNotFoundException;
import com.springboot.petcareservice.admin.model.Admin;
import com.springboot.petcareservice.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author prabhakar, @Date 20-09-2024
 */
@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepository;
    private final EntityConverter<Admin, AdminDto> entityConverter;

    @Override
    public Admin getAdminById(Long id) {
        return this.adminRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Admin Not Found..!"));
    }

    @Override
    public Admin getAdminByEmail(String email) {
        return this.adminRepository.findByEmail(email).orElseThrow(() ->
                new ResourceNotFoundException("Admin Not Found..! with: "+email));
    }

    @Override
    public Admin getAdminByMobile(String mobile) {
        return this.adminRepository.findByPhoneNumber(mobile).orElseThrow(() ->
                new ResourceNotFoundException("Admin Not Found..! with: "+mobile));
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        List<Admin> admins = this.adminRepository.findAll();
        return admins.stream()
                .map(admin -> entityConverter.mapEntityToDto(admin, AdminDto.class))
                .collect(Collectors.toList());
    }

}
