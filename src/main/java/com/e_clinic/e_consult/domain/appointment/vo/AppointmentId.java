package com.e_clinic.e_consult.domain.appointment.vo;

import java.util.Objects;
import java.util.UUID;

public record AppointmentId(UUID appointmentId) {
    public AppointmentId {
        Objects.requireNonNull(appointmentId);
    }

    public static AppointmentId of(UUID appointmentId) {
        return new AppointmentId(appointmentId);
    }

    public static AppointmentId of(String appointmentId) {
        return new AppointmentId(UUID.fromString(appointmentId));
    }

    public static AppointmentId generate() {
        return new AppointmentId(UUID.randomUUID());
    }
}
