package com.e_clinic.e_consult.application.appointment.mapper;

import com.e_clinic.e_consult.application.appointment.command.CreateAppointmentCommand;
import com.e_clinic.e_consult.domain.appointment.model.Appointment;
import com.e_clinic.e_consult.domain.appointment.vo.AppointmentDetails;
import com.e_clinic.e_consult.domain.appointment.vo.AppointmentLocation;

import java.util.UUID;

public class AppointmentDtoDomainMapper {

    private AppointmentDtoDomainMapper() {
    }

    public static Appointment toDomain(CreateAppointmentCommand command) {
        AppointmentLocation location = new AppointmentLocation(
                command.city(),
                command.street(),
                command.building(),
                command.floor()
        );

        AppointmentDetails details = new AppointmentDetails(
                command.appointmentDate(),
                location,
                command.reasonForVisit(),
                UUID.fromString(command.patientId()),
                UUID.fromString(command.doctorId())
        );

        return Appointment.newAppointment(details);
    }
}
