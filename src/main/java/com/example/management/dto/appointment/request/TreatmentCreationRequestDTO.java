package com.example.management.dto.appointment.request;

import com.example.management.entity.treatment.Treatment;

public class TreatmentCreationRequestDTO {

    private Treatment treatment;

    private String doctorUsername;

    private String nurseUsername;
    private String patientUsername;
    private String medicinesName;


    public TreatmentCreationRequestDTO(){}

    public TreatmentCreationRequestDTO(Treatment treatment, String doctorUsername,
                                       String nurseUsername, String patientUsername,
                                       String medicinesName) {
        this.treatment = treatment;
        this.doctorUsername = doctorUsername;
        this.nurseUsername = nurseUsername;
        this.patientUsername = patientUsername;
        this.medicinesName = medicinesName;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
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

    public String getMedicinesName() {
        return medicinesName;
    }

    public void setMedicinesName(String medicinesName) {
        this.medicinesName = medicinesName;
    }
}
