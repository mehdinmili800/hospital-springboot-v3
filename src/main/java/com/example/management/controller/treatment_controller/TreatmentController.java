package com.example.management.controller.treatment_controller;

import com.example.management.dto.appointment.request.AppointmentCreationRequest;
import com.example.management.dto.appointment.request.TreatmentCreationRequestDTO;
import com.example.management.entity.appointment.Appointment;
import com.example.management.entity.treatment.Treatment;
import com.example.management.service.appointmnent.AppointmentService;
import com.example.management.service.treatment.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class TreatmentController {

    private final TreatmentService treatmentService;


    @PostMapping("/treatment/create")
    public ResponseEntity<Treatment> createTreatment(@RequestBody TreatmentCreationRequestDTO request) {
        Treatment treatment = treatmentService.save(
                request.getTreatment(),
                request.getDoctorUsername(),
                request.getNurseUsername(),
                request.getPatientUsername(),
                request.getMedicinesName()
        );
        return ResponseEntity.ok(treatment);
    }

    @GetMapping("/treatment/all")
    public ResponseEntity<List<Treatment>> getAllTreatments() {
        List<Treatment> treatments = treatmentService.findAll();
        return ResponseEntity.ok().body(treatments);
    }

    @GetMapping("/treatment/user/{userId}")
    public ResponseEntity<List<Treatment>> getTreatmentsByUserId(@PathVariable Long userId) {
        List<Treatment> treatments = treatmentService.findTreatmentByUserId(userId);
        return ResponseEntity.ok().body(treatments);
    }

    @DeleteMapping("/treatment/{id}")
    public ResponseEntity<Void> deleteTreatment(@PathVariable Long id) {
        treatmentService.deleteById(id);
        return ResponseEntity.ok().build();

    }
}
