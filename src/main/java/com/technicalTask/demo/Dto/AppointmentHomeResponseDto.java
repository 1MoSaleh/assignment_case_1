package com.technicalTask.demo.Dto;

import com.technicalTask.demo.Entities.Appointment;
import com.technicalTask.demo.Enums.AppointmentStatuses;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AppointmentHomeResponseDto {
    private String patientNameEn;
    private String patientPhoneNumber;
    private LocalDateTime appointmentTime;
    private AppointmentStatuses appointmentStatus;

    public AppointmentHomeResponseDto(Appointment appointment){
        this.setPatientNameEn(appointment.getPatient().getNameEn());
        this.setPatientPhoneNumber(appointment.getPatient().getPhoneNumber());
        this.setAppointmentTime(appointment.getAppointmentTime());
        this.setAppointmentStatus(appointment.getAppointmentStatus());
    }
}
