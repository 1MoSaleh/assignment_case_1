package com.technicalTask.demo.Services.Impl;

import com.technicalTask.demo.Dto.PatientCreateRequestDto;
import com.technicalTask.demo.Entities.Patient;
import com.technicalTask.demo.Repositories.PatientRepository;
import com.technicalTask.demo.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository repository;

    @Override
    public void createPatient(PatientCreateRequestDto requestDto) {
        Patient patient = new Patient();
        requestDto.mapToEntity(patient);
        repository.save(patient);
    }
}
