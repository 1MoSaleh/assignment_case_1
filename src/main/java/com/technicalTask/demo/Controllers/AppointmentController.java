package com.technicalTask.demo.Controllers;

import com.technicalTask.demo.Dto.*;
import com.technicalTask.demo.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService service;

    @GetMapping(value = "/home")
    private ResponseEntity<List<AppointmentHomeResponseDto>> home(){
        List<AppointmentHomeResponseDto> responseDtoList = service.homeAppointments();

        return ResponseEntity.ok(responseDtoList);
    }

    @PutMapping(value = "/cancel")
    private ResponseEntity<String> cancel(@RequestBody @Valid AppointmentCancelRequestDto requestDto){
        service.cancelAppointment(requestDto);

        return ResponseEntity.ok("Appointment Cancelled Successfully");
    }

    @PostMapping(value = "/create")
    private ResponseEntity<String> create(@RequestBody @Valid AppointmentCreateRequestDto requestDto){
        service.createAppointment(requestDto);
        return ResponseEntity.ok("Appointment Created Successfully");
    }

    @PostMapping(value = "/filter-by-patient-name")
    private ResponseEntity<List<AppointmentListResponseDto>> filterByPatientName(@RequestBody @Valid AppointmentFilterByPatientNameRequestDto requestDto){
        List<AppointmentListResponseDto> responseDtoList = service.filterByPatientName(requestDto);
        return ResponseEntity.ok(responseDtoList);
    }

    @PostMapping(value = "/filter-by-date")
    private ResponseEntity<List<AppointmentListResponseDto>> filterByDate(@RequestBody @Valid AppointmentFilterByDateRequestDto requestDto){
        List<AppointmentListResponseDto> responseDtoList = service.filterByDate(requestDto);
        return ResponseEntity.ok(responseDtoList);
    }
}
