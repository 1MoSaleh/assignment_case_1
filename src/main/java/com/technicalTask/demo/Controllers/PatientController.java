package com.technicalTask.demo.Controllers;

import com.technicalTask.demo.Dto.PatientCreateRequestDto;
import com.technicalTask.demo.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService service;

    @PostMapping
    private ResponseEntity create(@RequestBody @Valid PatientCreateRequestDto requestDto){
        service.createPatient(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Patient Created Successfully");
    }
}
