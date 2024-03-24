package com.example.management.service.treatment;

import com.example.management.entity.treatment.Treatment;

import java.util.List;

public interface TreatmentService {

    Treatment save(Treatment treatment,String doctorUsername,String nurseUsername,
                   String patientUsername,String medicinesName);

    List<Treatment> findAll();

    void deleteById(Long id);

    List<Treatment> findTreatmentByUserId(Long userId);

}
