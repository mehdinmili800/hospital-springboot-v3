package com.example.management.entity.appointment;


import com.example.management.entity.hospital.Hospital;
import com.example.management.entity.user.User;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String appointmentNumber;
    private String appointmentType;
    private String appointmentDate;
    private String appointmentDescription;


    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private User doctor;

    @ManyToOne
    @JoinColumn(name = "nurse_id")
    private User nurse;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private User patient;


    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    public Appointment( String appointmentNumber,
                       String appointmentType, String appointmentDate,
                       String appointmentDescription,
                        User doctor, User nurse,User patient,
                        Hospital hospital) {

        this.appointmentNumber = appointmentNumber;
        this.appointmentType = appointmentType;
        this.appointmentDate = appointmentDate;
        this.appointmentDescription = appointmentDescription;
        this.doctor = doctor;
        this.nurse = nurse;
        this.patient = patient;
        this.hospital = hospital;
    }


    public Appointment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppointmentNumber() {
        return appointmentNumber;
    }

    public void setAppointmentNumber(String appointmentNumber) {
        this.appointmentNumber = appointmentNumber;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = appointmentDescription;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public User getNurse() {
        return nurse;
    }

    public void setNurse(User nurse) {
        this.nurse = nurse;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }
}
