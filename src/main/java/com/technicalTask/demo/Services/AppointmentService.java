package com.technicalTask.demo.Services;

import com.technicalTask.demo.Dto.*;

import java.util.List;

public interface AppointmentService {

    List<AppointmentHomeResponseDto> homeAppointments();

    void cancelAppointment(AppointmentCancelRequestDto requestDto);

    void createAppointment(AppointmentCreateRequestDto requestDto);

    List<AppointmentListResponseDto> filterByPatientName(AppointmentFilterByPatientNameRequestDto requestDto);

    List<AppointmentListResponseDto> filterByDate(AppointmentFilterByDateRequestDto requestDto);

}
