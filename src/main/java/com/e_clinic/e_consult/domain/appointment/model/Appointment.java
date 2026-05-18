package com.e_clinic.e_consult.domain.appointment.model;

import com.e_clinic.e_consult.domain.appointment.exception.InvalidAppointmentException;
import com.e_clinic.e_consult.domain.appointment.vo.AppointmentDetails;
import com.e_clinic.e_consult.domain.appointment.vo.AppointmentId;
import com.e_clinic.e_consult.domain.appointment.vo.AppointmentStatus;

import java.util.Objects;

public class Appointment {
    private AppointmentId appointmentId;
    private AppointmentDetails appointmentDetails;
    private AppointmentStatus appointmentStatus;

    private Appointment(AppointmentId appointmentId, AppointmentStatus appointmentStatus, AppointmentDetails appointmentDetails) {

        this.appointmentId = Objects.requireNonNull(appointmentId);
        this.appointmentStatus = Objects.requireNonNull(appointmentStatus);
        this.appointmentDetails = Objects.requireNonNull(appointmentDetails);
    }

    public static Appointment of(AppointmentId appointmentId, AppointmentStatus appointmentStatus, AppointmentDetails appointmentDetails) {
        return new Appointment(appointmentId, appointmentStatus, appointmentDetails);
    }

    public static Appointment newAppointment(AppointmentDetails appointmentDetails) {
        return new Appointment(AppointmentId.generate(), AppointmentStatus.SCHEDULED, appointmentDetails);
    }

    public void cancelAppointment() {
        if (this.appointmentStatus.equals(AppointmentStatus.CANCELLED) || this.appointmentStatus.equals(AppointmentStatus.COMPLETED)) {
            throw new InvalidAppointmentException("Appointment is cancelled/completed");
        }
        this.appointmentStatus = AppointmentStatus.CANCELLED;
    }

    public void rescheduleAppointment(AppointmentDetails appointmentDetails) {
        if (this.appointmentStatus.equals(AppointmentStatus.CANCELLED) || this.appointmentStatus.equals(AppointmentStatus.COMPLETED)) {
            throw new InvalidAppointmentException("Appointment is cancelled/completed");
        }
        this.appointmentStatus = AppointmentStatus.SCHEDULED;
        this.appointmentDetails = appointmentDetails;
    }

    public AppointmentId getAppointmentId() {
        return appointmentId;
    }

    public AppointmentDetails getAppointmentDetails() {
        return appointmentDetails;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

}


