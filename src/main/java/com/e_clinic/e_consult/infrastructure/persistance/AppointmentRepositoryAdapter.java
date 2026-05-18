package com.e_clinic.e_consult.infrastructure.persistance;

import com.e_clinic.e_consult.domain.appointment.model.Appointment;
import com.e_clinic.e_consult.domain.appointment.port.AppointmentRepository;
import com.e_clinic.e_consult.infrastructure.persistance.entity.AppointmentJpaEntity;
import com.e_clinic.e_consult.infrastructure.persistance.mapper.AppointmentDomainPersistenceMapper;
import com.e_clinic.e_consult.infrastructure.persistance.repo.AppointmentJpaRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class AppointmentRepositoryAdapter implements AppointmentRepository {

    private final AppointmentJpaRepository appointmentJpaRepository;

    @Override
    public Appointment save(Appointment appointment) {
        AppointmentJpaEntity entity = AppointmentDomainPersistenceMapper.toPersistence(appointment);
        AppointmentJpaEntity savedEntity = appointmentJpaRepository.save(entity);
        return AppointmentDomainPersistenceMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Appointment> findById(String appointmentId) {
        return appointmentJpaRepository.findById(java.util.UUID.fromString(appointmentId))
                .map(AppointmentDomainPersistenceMapper::toDomain);
    }

    @Override
    public Appointment update(Appointment appointment) {
        AppointmentJpaEntity entity = AppointmentDomainPersistenceMapper.toPersistence(appointment);
        AppointmentJpaEntity updatedEntity = appointmentJpaRepository.save(entity);
        return AppointmentDomainPersistenceMapper.toDomain(updatedEntity);
    }

    @Override
    public void delete(String appointmentId) {
        appointmentJpaRepository.deleteById(java.util.UUID.fromString(appointmentId));
    }
}
