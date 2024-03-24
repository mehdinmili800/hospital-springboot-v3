package com.example.management.dto.appointment.request;

import com.example.management.entity.appointment.Appointment;

public class AppointmentCreationRequest {
    private Appointment appointment;
    private String doctorUsername;
    private String nurseUsername;
    private String patientUsername;

    private String hospitalName;

    // Constructors, getters, and setters
    public AppointmentCreationRequest() {}

    public AppointmentCreationRequest(Appointment appointment, String doctorUsername,
                                      String nurseUsername, String patientUsername,String hospitalName) {
        this.appointment = appointment;
        this.doctorUsername = doctorUsername;
        this.nurseUsername = nurseUsername;
        this.patientUsername = patientUsername;
        this.hospitalName = hospitalName;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getDoctorUsername() {
        return doctorUsername;
    }

    public void setDoctorUsername(String doctorUsername) {
        this.doctorUsername = doctorUsername;
    }

    public String getNurseUsername() {
        return nurseUsername;
    }

    public void setNurseUsername(String nurseUsername) {
        this.nurseUsername = nurseUsername;
    }

    public String getPatientUsername() {
        return patientUsername;
    }

    public void setPatientUsername(String patientUsername) {
        this.patientUsername = patientUsername;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
