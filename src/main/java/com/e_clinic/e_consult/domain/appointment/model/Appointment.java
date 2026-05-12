package com.e_clinic.e_consult.domain.appointment.model;

import com.e_clinic.e_consult.domain.appointment.exception.InvalidAppointmentException;
import com.e_clinic.e_consult.domain.appointment.vo.AppointmentDetails;
import com.e_clinic.e_consult.domain.appointment.vo.AppointmentStatus;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.Objects;
import java.util.UUID;

public class Appointment extends AbstractAggregateRoot<Appointment> {
    private final UUID appointmentId;
    private AppointmentDetails appointmentDetails;
    private AppointmentStatus appointmentStatus;


    private Appointment(UUID appointmentId, AppointmentStatus appointmentStatus, AppointmentDetails appointmentDetails) {

        this.appointmentId = Objects.requireNonNull(appointmentId);
        this.appointmentStatus = Objects.requireNonNull(appointmentStatus);
        this.appointmentDetails = Objects.requireNonNull(appointmentDetails);
    }

    public static Appointment of(UUID appointmentId, AppointmentStatus appointmentStatus, AppointmentDetails appointmentDetails) {
        return new Appointment(appointmentId, appointmentStatus, appointmentDetails);
    }

    public static Appointment newAppointment(AppointmentDetails appointmentDetails) {
        return new Appointment(UUID.randomUUID(), AppointmentStatus.SCHEDULED, appointmentDetails);
    }

    public void cancelAppointment() {
        if (this.appointmentStatus.equals(AppointmentStatus.CANCELLED) ||
                this.appointmentStatus.equals(AppointmentStatus.COMPLETED)) {
            throw new InvalidAppointmentException("Appointment is cancelled/completed");
        }
        this.appointmentStatus = AppointmentStatus.CANCELLED;
    }

    public void rescheduleAppointment(AppointmentDetails appointmentDetails) {
        if (this.appointmentStatus.equals(AppointmentStatus.CANCELLED) ||
                this.appointmentStatus.equals(AppointmentStatus.COMPLETED)) {
            throw new InvalidAppointmentException("Appointment is cancelled/completed");
        }
        this.appointmentStatus = AppointmentStatus.SCHEDULED;
        this.appointmentDetails = appointmentDetails;
    }

}


