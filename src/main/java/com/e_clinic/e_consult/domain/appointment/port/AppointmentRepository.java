package com.e_clinic.e_consult.domain.appointment.port;

import com.e_clinic.e_consult.domain.appointment.model.Appointment;

import java.util.Optional;

public interface AppointmentRepository {
        Appointment save(Appointment appointment);
        Optional<Appointment> findById(String appointmentId);
        Appointment update(Appointment appointment);
        void delete(String appointmentId);
}
