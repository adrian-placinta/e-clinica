package com.e_clinic.e_consult.domain.appointment.vo;

import com.e_clinic.e_consult.domain.appointment.exception.InvalidAppointmentException;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public record AppointmentDetails(LocalDate appointmentDate,
                                 AppointmentLocation appointmentLocation,
                                 UUID patientId,
                                 UUID doctorId) {
    public AppointmentDetails {
        Objects.requireNonNull(appointmentDate);
        checkDateTimeValidity(appointmentDate);
        Objects.requireNonNull(appointmentLocation);
        Objects.requireNonNull(patientId);
        Objects.requireNonNull(doctorId);
    }

    private static void checkDateTimeValidity(LocalDate appointmentDate) {
        if (appointmentDate.isBefore(LocalDate.now())) {
            throw new InvalidAppointmentException("Invalid appointment date");
        }
    }

}
