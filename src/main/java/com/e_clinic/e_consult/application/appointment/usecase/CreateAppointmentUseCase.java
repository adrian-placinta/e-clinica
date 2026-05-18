package com.e_clinic.e_consult.application.appointment.usecase;

import com.e_clinic.e_consult.application.appointment.command.CreateAppointmentCommand;
import com.e_clinic.e_consult.domain.appointment.port.AppointmentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateAppointmentUseCase {
    private final AppointmentRepository repository;

    public void execute(CreateAppointmentCommand command) {

    }
}
