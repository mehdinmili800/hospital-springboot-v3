package com.example.management.service.treatment;

import com.example.management.entity.medicines.Medicines;
import com.example.management.entity.treatment.Treatment;
import com.example.management.entity.user.User;
import com.example.management.repository.medicines.MedicinesRepository;
import com.example.management.repository.treatment.TreatmentRepository;
import com.example.management.service.user.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TreatmentServiceImpl implements TreatmentService{

    private final TreatmentRepository treatmentRepository;
    private final UserService userService;
    private final MedicinesRepository medicinesRepository;

    @Override
    public Treatment save(Treatment treatment, String doctorUsername, String nurseUsername,
                          String patientUsername, String medicinesName) {
        User doctor = userService.findByUsername(doctorUsername);
        User nurse = userService.findByUsername(nurseUsername);
        User patient = userService.findByUsername(patientUsername);
        Medicines medicines = medicinesRepository.findByMedicineName(medicinesName);

        treatment.setDoctor(doctor);
        treatment.setNurse(nurse);
        treatment.setPatient(patient);
        treatment.setMedicines(medicines);
        return treatmentRepository.save(treatment);
    }

    @Override
    public List<Treatment> findAll() {
        return treatmentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        treatmentRepository.deleteById(id);
    }

    @Override
    public List<Treatment> findTreatmentByUserId(Long userId) {
        return treatmentRepository.findByDoctorIdOrNurseIdOrPatientIdOrMedicinesId(userId,userId,userId,userId);
    }


}
