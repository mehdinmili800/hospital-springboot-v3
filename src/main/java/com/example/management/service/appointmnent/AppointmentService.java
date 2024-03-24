package com.example.management.service.appointmnent;

import com.example.management.entity.appointment.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment save(Appointment appointment, String doctorUsername, String nurseUsername,
                     String patientUsername,String hospitalName);
    List<Appointment> findAll();

    void deleteById(Long id);

    List<Appointment> findAppointmentsByUserId(Long userId);


}
