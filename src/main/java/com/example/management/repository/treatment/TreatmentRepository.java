package com.example.management.repository.treatment;

import com.example.management.entity.treatment.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment,Long> {

    List<Treatment> findByDoctorIdOrNurseIdOrPatientIdOrMedicinesId(Long doctorId, Long nurseId,
                                                                    Long patientId,Long medicinesId);
}
