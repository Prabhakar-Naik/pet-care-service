package com.springboot.petcareservice.controller;

import com.springboot.petcareservice.dtos.AppointmentDto;
import com.springboot.petcareservice.dtos.EntityConverter;
import com.springboot.petcareservice.exceptions.UserAlreadyExistsException;
import com.springboot.petcareservice.model.Appointment;
import com.springboot.petcareservice.request.AppointmentRequest;
import com.springboot.petcareservice.response.ApiResponse;
import com.springboot.petcareservice.service.appointment.AppointmentService;
import com.springboot.petcareservice.utils.FeedBackMessage;
import com.springboot.petcareservice.utils.UrlMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @author prabhakar, @Date 20-09-2024
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value = UrlMapping.APPOINTMENTS)
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final EntityConverter<Appointment, AppointmentDto> entityConverter;

    @PostMapping(value = UrlMapping.CREATE_APPOINTMENT)
    public ResponseEntity<ApiResponse> createAppointment(@RequestBody AppointmentRequest request, @RequestParam Long senderId, @RequestParam Long recipientId) {
        try {
            Appointment appointment = this.appointmentService.createAppointment(request, senderId, recipientId);
            AppointmentDto appointmentDto = this.entityConverter.mapEntityToDto(appointment,AppointmentDto.class);
            return ResponseEntity.ok(new ApiResponse(FeedBackMessage.APPOINTMENT_CREATED,appointmentDto));
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(),null));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }

    }


}
