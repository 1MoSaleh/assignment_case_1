package com.technicalTask.demo.Services.Impl;

import com.technicalTask.demo.Dto.*;
import com.technicalTask.demo.Entities.Appointment;
import com.technicalTask.demo.Entities.Patient;
import com.technicalTask.demo.Repositories.AppointmentRepository;
import com.technicalTask.demo.Repositories.PatientRepository;
import com.technicalTask.demo.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository repository;

    @Autowired
    PatientRepository patientRepository;


    @Override
    public List<AppointmentHomeResponseDto> homeAppointments() {
        List<AppointmentHomeResponseDto> responseDtoList;
        // map every object in the List<appointment> to List of appointments dto object
        responseDtoList = repository.getAppointmentByDate(new Date()).stream()
                .map(appointment -> new AppointmentHomeResponseDto(appointment))
                .collect(Collectors.toList());

        return responseDtoList;
    }

    @Override
    public void cancelAppointment(AppointmentCancelRequestDto requestDto) {
        // we don't have custom exception, so we will throw runtime exception in case if appointment not found
        Appointment appointment = repository.findById(requestDto.getAppointmentId()).orElseThrow(()-> new RuntimeException("Appointment_not_found"));
        requestDto.mapToEntity(appointment);
        repository.save(appointment);
    }

    @Override
    public void createAppointment(AppointmentCreateRequestDto requestDto) {
        Appointment appointment = new Appointment();
        Patient patient = patientRepository.getPatientsByPhoneNumber(requestDto.getPatientPhoneNumber());
        requestDto.mapToEntity(appointment);
        appointment.setPatient(patient);
        repository.save(appointment);
    }

    @Override
    public List<AppointmentListResponseDto> filterByPatientName(AppointmentFilterByPatientNameRequestDto requestDto) {
        List<AppointmentListResponseDto> responseDtoList;
       // map every object in the List<appointment> to List of appointments dto object
        responseDtoList = repository.filterByPatientName(requestDto.getPatientName()).stream()
                .map(appointment -> new AppointmentListResponseDto(appointment))
                .collect(Collectors.toList());

        return responseDtoList;
    }

    @Override
    public List<AppointmentListResponseDto> filterByDate(AppointmentFilterByDateRequestDto requestDto) {
        List<AppointmentListResponseDto> responseDtoList;
        // map every object in the List<appointment> to List of appointments dto object
        responseDtoList = repository.getAppointmentByDate(requestDto.getAppointmentTime()).stream()
                .map(appointment -> new AppointmentListResponseDto(appointment))
                .collect(Collectors.toList());

        return responseDtoList;
    }
}
