package com.technicalTask.demo.Dto;

import javax.validation.constraints.NotNull;
import com.technicalTask.demo.Entities.Patient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PatientCreateRequestDto {
    @NotNull
    private String nameEn;
    @NotNull
    private String phoneNumber;


    // used to map dto values to Patient entity
    public void mapToEntity(Patient patient){
        patient.setNameEn(nameEn);
        patient.setPhoneNumber(phoneNumber);
        patient.setCreatedAt(LocalDateTime.now());
    }
}
