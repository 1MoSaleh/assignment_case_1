package com.technicalTask.demo.Repositories;

import com.technicalTask.demo.Entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    @Query(value = "select a from Appointment a where cast(a.appointmentTime as date) = :date")
    List<Appointment> getAppointmentByDate(@Param("date")Date date);

    @Query(value = "select a from Appointment a where a.patient.nameEn = :patientName")
    List<Appointment> filterByPatientName(@Param("patientName")String patientName);


}
