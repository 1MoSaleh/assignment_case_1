package com.technicalTask.demo.Repositories;

import com.technicalTask.demo.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient getPatientsByPhoneNumber(String phoneNumber);
}
