package com.example.management.service.medicines;

import com.example.management.dto.user.MedicinesResponseDTO;
import com.example.management.entity.medicines.Medicines;
import com.example.management.repository.medicines.MedicinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicinesServiceImpl implements MedicinesService{

    @Autowired
    private MedicinesRepository medicinesRepository;

    @Override
    public Medicines create(MedicinesResponseDTO medicinesResponseDTO) {
        Medicines medicines = new Medicines();
        medicines.setMedicineName(medicinesResponseDTO.getMedicineName());
        medicines.setMedicine_company(medicinesResponseDTO.getMedicine_company());
        medicines.setMedicine_composition(medicinesResponseDTO.getMedicine_composition());
        medicines.setMedicine_cost(medicinesResponseDTO.getMedicine_cost());
        medicines.setMedicine_type(medicinesResponseDTO.getMedicine_type());
        medicines.setMedicine_dose(medicinesResponseDTO.getMedicine_dose());
        medicines.setMedicine_description(medicinesResponseDTO.getMedicine_description());

        return medicinesRepository.save(medicines);
    }

    @Override
    public List<Medicines> findAll() {
        return medicinesRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        medicinesRepository.deleteById(id);
    }
}
