package com.technicalTask.demo.Dto;

import javax.validation.constraints.NotNull;
import com.technicalTask.demo.Entities.Appointment;
import com.technicalTask.demo.Enums.AppointmentStatuses;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AppointmentCancelRequestDto {
    @NotNull
    private long appointmentId;
    @NotNull
    private String cancellationStatus;

    public void mapToEntity(Appointment appointment){
        appointment.setAppointmentStatus(AppointmentStatuses.valueOf(cancellationStatus));
        appointment.setCancelledAt(LocalDateTime.now());
    }
}
