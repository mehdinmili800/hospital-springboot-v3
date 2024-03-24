package com.example.management.controller.hospital_controller;

import com.example.management.dto.hospital.HospitalResponseDTO;
import com.example.management.entity.appointment.Appointment;
import com.example.management.entity.hospital.Hospital;
import com.example.management.service.hospital.HospitalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class HospitalController {

    @Autowired
    private HospitalServiceImpl hospitalService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/hospital/create")
    public Hospital create(@RequestBody HospitalResponseDTO hospitalResponseDTO){
        return hospitalService.create(hospitalResponseDTO);
    }

    @GetMapping(value = "/hospitals/all")
    public List<Hospital> findAll(){
        return hospitalService.findAll();
    }

    @DeleteMapping("/hospital/{id}")
    public ResponseEntity<Void> deleteHospital(@PathVariable Long id) {
        hospitalService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
