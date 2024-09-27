package com.springboot.petcareservice.utils;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author prabhakar, @Date 19-09-2024
 */
public class UrlMapping {

//    @Value("${api.prefix}")       // not working properly
//    public static String api;

    // base api
    public static final String API = "/api/v1";
    // sub api s

    // user api s
    public static final String USERS = API+"/users";

    public static final String CREATE_USER = "/createUser";

    public static final String UPDATE_USER = "/updateUser/{userId}";

    public static final String GET_USER = "/getUserById/{userId}";

    public static final String DELETE_USER = "/deleteUserById/{userId}";

    public static final String GET_ALL_USERS = "/getAllUsers";


    // admin api s
    public static final String ADMINS = API+"/admins";

    public static final String GET_ALL_ADMINS = "/getAllAdmins";

    public static final String GET_ADMIN = "/getAdminById/{adminId}";

    public static final String GET_ADMIN_BY_MAIL = "/getAdminByEmail";

    public static final String GET_ADMIN_BY_MOBILE = "/getAdminByMobile";

    // patient api s

    public static final String PATIENTS = API+"/patients";

    public static final String GET_ALL_PATIENTS = "/getAllPatients";

    public static final String GET_PATIENT = "/getPatientById/{patientId}";

    public static final String GET_PATIENT_BY_MAIL = "/getPatientByEmail";

    public static final String GET_PATIENT_BY_MOBILE = "/getPatientByMobile";

    // veterinarian api s
    public static final String VETERINARIES =API+"/veterinaries";

    public static final String GET_VETERINARY = "/getVeterinarianById/{vetId}";

    public static final String GET_VETERINARY_BY_MAIL = "/getVeterinarianByEmail";
    public static final String GET_VETERINARY_BY_MOBILE = "/getVeterinarianByMobile";

    public static final String GET_ALL_VETS = "/getAllVeterinaries";

    // appointment api s
    public static final String APPOINTMENTS = API+"/appointments";

    public static final String CREATE_APPOINTMENT = "/createAppointment";

    public static final String GET_ALL_APPOINTMENTS = "/getAllAppointments";

    public static final String GET_APPOINTMENT = "/getAppointmentById/{appointmentId}";

    public static final String UPDATE_APPOINTMENT = "/updateAppointment/{appointmentId}";

    public static final String GET_APPOINTMENT_BY_NO="/getAppointmentByNo/{appointmentNo}";

    public static final String DELETE_APPOINTMENT = "/deleteAppointment/{appointmentId}";

}
