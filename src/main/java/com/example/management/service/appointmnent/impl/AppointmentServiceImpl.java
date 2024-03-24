package com.example.management.service.appointmnent.impl;

import com.example.management.entity.appointment.Appointment;

import com.example.management.entity.hospital.Hospital;
import com.example.management.entity.user.User;
import com.example.management.repository.appointment.AppointmentRepository;

import com.example.management.repository.hospital.HospitalRepository;
import com.example.management.service.appointmnent.AppointmentService;
import com.example.management.service.user.user.UserService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserService userService;
    private final HospitalRepository hospitalRepository;



    @Override
    public Appointment save(Appointment appointment, String doctorUsername, String nurseUsername,
                            String patientUsername,String hospitalName) {
        User doctor = userService.findByUsername(doctorUsername);
        User nurse = userService.findByUsername(nurseUsername);
        User patient = userService.findByUsername(patientUsername);
        Hospital hospital = hospitalRepository.findByHospitalName(hospitalName);

        appointment.setDoctor(doctor);
        appointment.setNurse(nurse);
        appointment.setPatient(patient);
        appointment.setHospital(hospital);

        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }



    @Override
    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }



    @Override
    public List<Appointment> findAppointmentsByUserId(Long userId) {
        return appointmentRepository.findByDoctorIdOrNurseIdOrPatientIdOrHospitalId(userId, userId, userId,userId);
    }

}
