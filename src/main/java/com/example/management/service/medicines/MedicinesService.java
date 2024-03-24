package com.example.management.service.medicines;

import com.example.management.dto.user.MedicinesResponseDTO;
import com.example.management.entity.medicines.Medicines;

import java.util.List;

public interface MedicinesService {

    Medicines create(MedicinesResponseDTO medicinesResponseDTO);

    List<Medicines> findAll();

    void deleteById(Long id);
}
