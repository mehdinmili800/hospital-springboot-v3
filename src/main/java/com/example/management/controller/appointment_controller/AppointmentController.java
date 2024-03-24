package com.example.management.controller.appointment_controller;

import com.example.management.dto.appointment.request.AppointmentCreationRequest;
import com.example.management.entity.appointment.Appointment;

import com.example.management.service.appointmnent.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AppointmentController {


    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/appointment/create")
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentCreationRequest request) {
        Appointment savedAppointment = appointmentService.save(
                request.getAppointment(),
                request.getDoctorUsername(),
                request.getNurseUsername(),
                request.getPatientUsername(),
                request.getHospitalName()
        );
        return ResponseEntity.ok(savedAppointment);
    }

    @GetMapping("/appointment/all")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.findAll();
        return ResponseEntity.ok().body(appointments);
    }

    @DeleteMapping("/appointment/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/appointment/user/{userId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByUserId(@PathVariable Long userId) {
        List<Appointment> appointments = appointmentService.findAppointmentsByUserId(userId);
        return ResponseEntity.ok().body(appointments);
    }
}
