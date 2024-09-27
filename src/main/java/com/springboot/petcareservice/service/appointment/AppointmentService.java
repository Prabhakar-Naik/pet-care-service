package com.springboot.petcareservice.service.appointment;

import com.springboot.petcareservice.enums.AppointmentStatus;
import com.springboot.petcareservice.model.Appointment;
import com.springboot.petcareservice.request.AppointmentRequest;

import java.util.List;

/**
 * @author prabhakar, @Date 20-09-2024
 */
public interface AppointmentService {

    Appointment createAppointment(AppointmentRequest request, Long senderId, Long recipientId);

    Appointment updateAppointmentStatus(Long appointmentId, Long recipientId, AppointmentStatus status);

    Appointment cancelAppointmentBySender(Long appointmentId, Long senderId, AppointmentStatus status);

    List<Appointment> getAllAppointments();

    Appointment updateAppointment(Long id, AppointmentRequest request);

    void deleteAppointment(Long id);

    Appointment getAppointmentById(Long id);

    Appointment getAppointmentByNo(String appointmentNo);

}
