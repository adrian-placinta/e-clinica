package com.e_clinic.e_consult.application.appointment.command;

import java.time.LocalDate;

public record CreateAppointmentCommand(
        String patientId,
        String doctorId,
        LocalDate appointmentDate,
        String reasonForVisit,
        String city,
        String street,
        String building,
        String floor) {
}
