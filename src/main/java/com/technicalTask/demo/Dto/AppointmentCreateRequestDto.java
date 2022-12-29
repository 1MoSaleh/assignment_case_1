package com.technicalTask.demo.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.technicalTask.demo.Entities.Appointment;
import com.technicalTask.demo.Enums.AppointmentStatuses;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Setter
@Getter
public class AppointmentCreateRequestDto {
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime appointmentTime;
    @NotNull
    private String patientPhoneNumber;

    public void mapToEntity(Appointment appointment){
        appointment.setAppointmentTime(appointmentTime);
        appointment.setCreatedAt(LocalDateTime.now());
        appointment.setAppointmentStatus(AppointmentStatuses.ACTIVE);
    }
}
