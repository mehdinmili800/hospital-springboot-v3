package com.example.management.controller.medicines_controller;

import com.example.management.dto.user.MedicinesResponseDTO;
import com.example.management.entity.medicines.Medicines;
import com.example.management.service.hospital.HospitalServiceImpl;
import com.example.management.service.medicines.MedicinesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class MedicinesController {

    @Autowired
    private MedicinesServiceImpl medicinesService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/medicines/create")
    public Medicines create(@RequestBody MedicinesResponseDTO medicinesResponseDTO){
        return medicinesService.create(medicinesResponseDTO);
    }

    @GetMapping(value = "/medicines/all")
    public List<Medicines> findAll(){
        return medicinesService.findAll();
    }

    @DeleteMapping("/medicines/{id}")
    public ResponseEntity<Void> deleteMedicines(@PathVariable Long id) {
        medicinesService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
