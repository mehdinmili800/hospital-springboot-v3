package com.example.management.repository.appointment;

import com.example.management.entity.appointment.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    List<Appointment> findByDoctorIdOrNurseIdOrPatientIdOrHospitalId(Long doctorId, Long nurseId,
                                                                     Long patientId,Long hospitalId);


}

