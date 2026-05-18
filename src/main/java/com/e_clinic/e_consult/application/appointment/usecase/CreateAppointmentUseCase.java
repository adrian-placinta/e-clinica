package com.e_clinic.e_consult.application.appointment.usecase;

import com.e_clinic.e_consult.application.appointment.command.CreateAppointmentCommand;
import com.e_clinic.e_consult.application.appointment.mapper.AppointmentDtoDomainMapper;
import com.e_clinic.e_consult.domain.appointment.model.Appointment;
import com.e_clinic.e_consult.domain.appointment.port.AppointmentRepository;

public class CreateAppointmentUseCase {
    private final AppointmentRepository appointmentRepository;

    public CreateAppointmentUseCase(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment execute(CreateAppointmentCommand command) {
        return appointmentRepository.save(AppointmentDtoDomainMapper.toDomain(command));
    }
}
