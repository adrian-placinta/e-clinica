package com.e_clinic.e_consult.infrastructure.config;

import com.e_clinic.e_consult.application.appointment.usecase.CreateAppointmentUseCase;
import com.e_clinic.e_consult.infrastructure.persistance.AppointmentRepositoryAdapter;
import com.e_clinic.e_consult.infrastructure.persistance.repo.AppointmentJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanContainer {
    @Bean
    AppointmentRepositoryAdapter appointmentRepositoryAdapter(AppointmentJpaRepository appointmentJpaRepository) {
        return new AppointmentRepositoryAdapter(appointmentJpaRepository);
    }

    @Bean
    CreateAppointmentUseCase createAppointmentUseCase(AppointmentRepositoryAdapter appointmentRepositoryAdapter) {
        return new CreateAppointmentUseCase(appointmentRepositoryAdapter);
    }

}
