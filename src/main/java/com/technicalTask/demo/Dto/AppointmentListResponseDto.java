package com.technicalTask.demo.Dto;

import com.technicalTask.demo.Entities.Appointment;
import com.technicalTask.demo.Enums.AppointmentStatuses;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppointmentListResponseDto {
    private long appointmentId;
    private String patientNameEn;
    private String patientPhoneNumber;
    private AppointmentStatuses appointmentStatus;

    public AppointmentListResponseDto(Appointment appointment){
        setAppointmentId(appointment.getId());
        setPatientNameEn(appointment.getPatient().getNameEn());
        setPatientPhoneNumber(appointment.getPatient().getPhoneNumber());
        setAppointmentStatus(appointment.getAppointmentStatus());
    }
}
