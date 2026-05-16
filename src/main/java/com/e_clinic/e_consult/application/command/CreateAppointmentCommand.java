package com.e_clinic.e_consult.application.command;

import com.e_clinic.e_consult.domain.appointment.vo.AppointmentLocation;

import java.time.LocalDate;
import java.util.UUID;

public record CreateAppointmentCommand(LocalDate appointmentDate,
                                       AppointmentLocation appointmentLocation,
                                       UUID patientId,
                                       UUID doctorId) {
}
