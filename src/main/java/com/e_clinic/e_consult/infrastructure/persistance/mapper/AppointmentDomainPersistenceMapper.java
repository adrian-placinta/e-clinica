package com.e_clinic.e_consult.infrastructure.persistance.mapper;

import com.e_clinic.e_consult.domain.appointment.model.Appointment;
import com.e_clinic.e_consult.domain.appointment.vo.AppointmentDetails;
import com.e_clinic.e_consult.domain.appointment.vo.AppointmentLocation;
import com.e_clinic.e_consult.infrastructure.persistance.entity.AppointmentJpaEntity;

public class AppointmentDomainPersistenceMapper {

    private AppointmentDomainPersistenceMapper() {
    }

    public static AppointmentJpaEntity toPersistence(Appointment domain) {
        AppointmentDetails details = domain.getAppointmentDetails();
        AppointmentLocation location = details.appointmentLocation();

        return AppointmentJpaEntity.builder()
                .id(domain.getAppointmentId().appointmentId())
                .patientId(details.patientId())
                .doctorId(details.doctorId())
                .appointmentDate(details.appointmentDate())
                .reasonForVisit(details.reasonForVisit())
                .city(location.city())
                .street(location.street())
                .building(location.building())
                .floor(location.floor())
                .status(AppointmentJpaEntity.AppointmentStatus.valueOf(domain.getAppointmentStatus().name()))
                .build();
    }

    public static Appointment toDomain(AppointmentJpaEntity entity) {
        AppointmentLocation location = new AppointmentLocation(
                entity.getCity(),
                entity.getStreet(),
                entity.getBuilding(),
                entity.getFloor()
        );

        AppointmentDetails details = new AppointmentDetails(
                entity.getAppointmentDate(),
                location,
                entity.getReasonForVisit(),
                entity.getPatientId(),
                entity.getDoctorId()
        );

        return Appointment.of(
                com.e_clinic.e_consult.domain.appointment.vo.AppointmentId.of(entity.getId()),
                com.e_clinic.e_consult.domain.appointment.vo.AppointmentStatus.valueOf(entity.getStatus().name()),
                details
        );
    }
}
