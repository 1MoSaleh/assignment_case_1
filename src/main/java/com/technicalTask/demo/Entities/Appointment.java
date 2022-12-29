package com.technicalTask.demo.Entities;

import com.technicalTask.demo.Enums.AppointmentStatuses;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "APPOINTMENT_TBL")
@Setter
@Getter
public class Appointment {
    @Id
    @Column(name = "PK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "APPOINTMENT_TIME")
    private LocalDateTime appointmentTime;

    @Column(name = "APPOINTMENT_STATUS")
    @Enumerated(EnumType.STRING)
    private AppointmentStatuses appointmentStatus;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @Column(name = "CANCELLED_AT")
    private LocalDateTime cancelledAt;

    @ManyToOne
    @JoinColumn(name = "FK_PATIENT_ID")
    private Patient patient;
}
