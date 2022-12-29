package com.technicalTask.demo.Dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppointmentFilterByPatientNameRequestDto {
    @NotNull
    private String patientName;
}
