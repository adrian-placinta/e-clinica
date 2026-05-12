package com.e_clinic.e_consult.domain.appointment.exception;

public class InvalidAppointmentException extends RuntimeException {
    public InvalidAppointmentException(String message) {
        super(message);
    }
}
