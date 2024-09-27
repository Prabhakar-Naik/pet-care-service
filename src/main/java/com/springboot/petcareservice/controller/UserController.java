package com.springboot.petcareservice.controller;

import com.springboot.petcareservice.dtos.EntityConverter;
import com.springboot.petcareservice.dtos.UserDto;
import com.springboot.petcareservice.exceptions.UserAlreadyExistsException;
import com.springboot.petcareservice.exceptions.UserNotFoundException;
import com.springboot.petcareservice.model.User;
import com.springboot.petcareservice.request.RegistrationRequest;
import com.springboot.petcareservice.request.UserUpdateRequest;
import com.springboot.petcareservice.response.ApiResponse;
import com.springboot.petcareservice.service.user.UserService;
import com.springboot.petcareservice.utils.FeedBackMessage;
import com.springboot.petcareservice.utils.UrlMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

/**
 * @author prabhakar, @Date 17-09-2024
 */
@RequiredArgsConstructor
@RequestMapping( value = UrlMapping.USERS)
@RestController
public class UserController {

    private final UserService UserService;
    private final EntityConverter<User, UserDto> entityConverter;

    @PostMapping(value = UrlMapping.CREATE_USER)
    public ResponseEntity<ApiResponse> addUser(@RequestBody RegistrationRequest request) {
        try {
            User theUser = this.UserService.addUser(request);
            UserDto userDto = this.entityConverter.mapEntityToDto(theUser,UserDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.REGISTER_SUCCESS,userDto));
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }

    }

    @PutMapping(value = UrlMapping.UPDATE_USER)
    public ResponseEntity<ApiResponse> updateUser(@PathVariable Long userId, @RequestBody UserUpdateRequest request){
        try {
            User theUser = this.UserService.updateUser(userId,request);
            UserDto userDto = this.entityConverter.mapEntityToDto(theUser, UserDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.UPDATE_SUCCESS,userDto));
        }catch (UserNotFoundException e){
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping(value = UrlMapping.GET_USER)
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long userId){
        try {
            User theUser = this.UserService.findByUserId(userId);
            UserDto userDto = this.entityConverter.mapEntityToDto(theUser, UserDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DATA_FOUND,userDto));
        }catch (UserNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @DeleteMapping(value = UrlMapping.DELETE_USER)
    public ResponseEntity<ApiResponse> deleteUserById(@PathVariable Long userId){
        try {
            this.UserService.deleteByUserId(userId);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DELETE_SUCCESS,null));
        }catch (UserNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping(value = UrlMapping.GET_ALL_USERS)
    public ResponseEntity<ApiResponse> getAllUsers(){
        try {
            List<UserDto> userDtoList = this.UserService.findByUsers();
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DATA_FOUND,userDtoList));
        }catch (UserNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }




}
