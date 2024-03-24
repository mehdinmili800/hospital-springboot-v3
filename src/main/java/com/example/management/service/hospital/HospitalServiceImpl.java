package com.example.management.service.hospital;

import com.example.management.dto.hospital.HospitalResponseDTO;
import com.example.management.entity.hospital.Hospital;
import com.example.management.repository.hospital.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService{

    @Autowired
    private HospitalRepository hospitalRepository;
    @Override
    public Hospital create(HospitalResponseDTO hospitalResponseDTO) {
        Hospital hospital = new Hospital();
        hospital.setHospitalName(hospitalResponseDTO.getHospitalName());
        hospital.setHospital_type(hospitalResponseDTO.getHospital_type());
        hospital.setHospital_description(hospitalResponseDTO.getHospital_description());
        hospital.setHospital_place(hospitalResponseDTO.getHospital_place());
        hospital.setHospital_address(hospitalResponseDTO.getHospital_address());


        return hospitalRepository.save(hospital);
    }

    @Override
    public List<Hospital> findAll() {
        return hospitalRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        hospitalRepository.deleteById(id);
    }


}
