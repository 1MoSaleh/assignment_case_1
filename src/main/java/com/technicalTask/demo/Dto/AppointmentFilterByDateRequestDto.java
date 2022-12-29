package com.technicalTask.demo.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class AppointmentFilterByDateRequestDto {
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date appointmentTime;
}
