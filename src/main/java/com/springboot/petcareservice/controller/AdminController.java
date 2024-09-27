package com.springboot.petcareservice.controller;

import com.springboot.petcareservice.dtos.AdminDto;
import com.springboot.petcareservice.dtos.EntityConverter;
import com.springboot.petcareservice.dtos.UserDto;
import com.springboot.petcareservice.exceptions.ResourceNotFoundException;
import com.springboot.petcareservice.exceptions.UserNotFoundException;
import com.springboot.petcareservice.model.Admin;
import com.springboot.petcareservice.response.ApiResponse;
import com.springboot.petcareservice.service.admin.AdminService;
import com.springboot.petcareservice.utils.FeedBackMessage;
import com.springboot.petcareservice.utils.UrlMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author prabhakar, @Date 17-09-2024
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value = UrlMapping.ADMINS)
public class AdminController {

    private final AdminService adminService;
    private final EntityConverter<Admin, AdminDto> entityConverter;

    @GetMapping(value = UrlMapping.GET_ADMIN)
    public ResponseEntity<ApiResponse> getAdminById(@PathVariable Long adminId){
        try{
            Admin admin = this.adminService.getAdminById(adminId);
            AdminDto adminDto = this.entityConverter.mapEntityToDto(admin, AdminDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DATA_FOUND,adminDto));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping(value = UrlMapping.GET_ADMIN_BY_MAIL)
    public ResponseEntity<ApiResponse> getAdminByEmail(@RequestParam String email){
        try{
            Admin admin = this.adminService.getAdminByEmail(email);
            AdminDto adminDto = this.entityConverter.mapEntityToDto(admin, AdminDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DATA_FOUND,adminDto));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping(value = UrlMapping.GET_ADMIN_BY_MOBILE)
    public ResponseEntity<ApiResponse> getAdminByMobile(@RequestParam String mobile){
        try{
            Admin admin = this.adminService.getAdminByMobile(mobile);
            AdminDto adminDto = this.entityConverter.mapEntityToDto(admin, AdminDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DATA_FOUND,adminDto));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping(value = UrlMapping.GET_ALL_ADMINS)
    public ResponseEntity<ApiResponse> getAllAdmins(){
        try {
            List<AdminDto> admins = this.adminService.getAllAdmins();
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DATA_FOUND,admins));
        }catch (UserNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }


}
