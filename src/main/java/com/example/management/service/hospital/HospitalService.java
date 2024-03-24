package com.example.management.service.hospital;

import com.example.management.dto.hospital.HospitalResponseDTO;
import com.example.management.entity.hospital.Hospital;

import java.util.List;

public interface HospitalService {

    Hospital create(HospitalResponseDTO hospitalResponseDTO);

    List<Hospital> findAll();

    void deleteById(Long id);
}
