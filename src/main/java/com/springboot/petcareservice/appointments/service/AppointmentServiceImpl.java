package com.springboot.petcareservice.appointments.service;

import com.springboot.petcareservice.enums.AppointmentStatus;
import com.springboot.petcareservice.exceptions.ResourceNotFoundException;
import com.springboot.petcareservice.exceptions.UserNotFoundException;
import com.springboot.petcareservice.appointments.model.Appointment;
import com.springboot.petcareservice.users.model.User;
import com.springboot.petcareservice.appointments.repository.AppointmentRepository;
import com.springboot.petcareservice.users.repository.UserRepository;
import com.springboot.petcareservice.request.AppointmentRequest;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author prabhakar, @Date 20-09-2024
 */
@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService{

    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;

    @Override
    public Appointment createAppointment(AppointmentRequest request, Long senderId, Long recipientId) {
        Optional<User> sender = this.userRepository.findById(senderId);
        Optional<User> recipient = this.userRepository.findById(recipientId);
        Appointment appointment = new Appointment();
        if (sender.isPresent() && recipient.isPresent()){
            appointment.setReason(request.getReason());
            appointment.setDate(request.getDate());
            appointment.setTime(request.getTime());
            appointment.setCreatedAt(LocalDate.now());
            appointment.setPatient(sender.get());
            appointment.setVeterinarian(recipient.get());
            appointment.setAppointmentNo();
            appointment.setStatus(AppointmentStatus.WAITING_FOR_APPROVAL);
            return this.appointmentRepository.save(appointment);
        }
        throw new UserNotFoundException("Sender or recipient not found");
    }

    @Override
    public Appointment updateAppointmentStatus(Long appointmentId, Long recipientId, AppointmentStatus status) {
        return getAppointment(appointmentId, recipientId, status);
    }

    @Override
    public Appointment cancelAppointmentBySender(Long appointmentId, Long senderId, AppointmentStatus status) {
        return getAppointment(appointmentId, senderId, status);
    }

    @NotNull
    private Appointment getAppointment(Long appointmentId, Long senderId, AppointmentStatus status) {
        Appointment appointment = this.getAppointmentById(appointmentId);
        Optional<User> recipient = this.userRepository.findById(senderId);
        Optional<User> sender = this.userRepository.findById(appointment.getPatient().getId());
        if (recipient.isPresent() && sender.isPresent()) {
            appointment.setStatus(status);
            return this.appointmentRepository.save(appointment);
        }
        throw new ResourceNotFoundException("Sender or recipient not found");
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return this.appointmentRepository.findAll();
    }

    @Override
    public Appointment updateAppointment(Long id, AppointmentRequest request) {
        return this.appointmentRepository.findById(id).map(exist -> updateExistingAppointment(exist,request))
                .map(this.appointmentRepository::save)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment Not Found"));
    }

    private Appointment updateExistingAppointment(Appointment existedAppointment, AppointmentRequest request){
        existedAppointment.setReason(request.getReason());
        existedAppointment.setAppointmentNo();
        existedAppointment.setDate(request.getDate());
        existedAppointment.setTime(request.getTime());
        existedAppointment.setCreatedAt(LocalDate.now());

        return existedAppointment;
    }

    @Override
    public void deleteAppointment(Long id) {
        this.appointmentRepository.findById(id)
                .ifPresent(this.appointmentRepository::delete);

    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return this.appointmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Appointment Not Found"));
    }

    @Override
    public Appointment getAppointmentByNo(String appointmentNo) {
        return this.appointmentRepository.findByAppointmentNo(appointmentNo);
    }
}
