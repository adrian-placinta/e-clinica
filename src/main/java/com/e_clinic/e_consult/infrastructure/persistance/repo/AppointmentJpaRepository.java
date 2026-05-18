package com.e_clinic.e_consult.infrastructure.persistance.repo;

import com.e_clinic.e_consult.infrastructure.persistance.entity.AppointmentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppointmentJpaRepository extends JpaRepository<AppointmentJpaEntity, UUID> {
}
