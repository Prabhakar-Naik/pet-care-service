package com.springboot.petcareservice.veterinarians.controller;

import com.springboot.petcareservice.dtos.EntityConverter;
import com.springboot.petcareservice.dtos.VeterinarianDto;
import com.springboot.petcareservice.exceptions.ResourceNotFoundException;
import com.springboot.petcareservice.exceptions.UserNotFoundException;
import com.springboot.petcareservice.veterinarians.model.Veterinarian;
import com.springboot.petcareservice.response.ApiResponse;
import com.springboot.petcareservice.veterinarians.service.VeterinarianService;
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
@RequestMapping(value = UrlMapping.VETERINARIES)
public class VeterinarianController {

    private final VeterinarianService veterinarianService;
    private final EntityConverter<Veterinarian, VeterinarianDto> entityConverter;

    @GetMapping(value = UrlMapping.GET_VETERINARY)
    public ResponseEntity<ApiResponse> getVeterinarianById(@PathVariable Long vetId){
        try{
            Veterinarian veterinarian = this.veterinarianService.getVeterinarianById(vetId);
            VeterinarianDto veterinarianDto = this.entityConverter.mapEntityToDto(veterinarian, VeterinarianDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DATA_FOUND,veterinarianDto));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping(value = UrlMapping.GET_VETERINARY_BY_MAIL)
    public ResponseEntity<ApiResponse> getVeterinarianByEmail(@RequestParam String email){
        try{
            Veterinarian veterinarian = this.veterinarianService.getVeterinarianByEmail(email);
            VeterinarianDto veterinarianDto = this.entityConverter.mapEntityToDto(veterinarian, VeterinarianDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DATA_FOUND,veterinarianDto));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping(value = UrlMapping.GET_VETERINARY_BY_MOBILE)
    public ResponseEntity<ApiResponse> getVeterinarianByMobile(@RequestParam String mobile){
        try{
            Veterinarian veterinarian = this.veterinarianService.getVeterinarianByMobile(mobile);
            VeterinarianDto veterinarianDto = this.entityConverter.mapEntityToDto(veterinarian, VeterinarianDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DATA_FOUND,veterinarianDto));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping(value = UrlMapping.GET_ALL_VETS)
    public ResponseEntity<ApiResponse> getAllVeterinarians(){
        try {
            List<VeterinarianDto> veterinarians = this.veterinarianService.getAllVeterinarians();
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.DATA_FOUND,veterinarians));
        }catch (UserNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }
}
