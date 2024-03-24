package com.example.management.dto.treatment;

public class TreatmentResponseDTO {

    private String doctorName;
    private String patientName;
    private String medicineName;
    private String treatmentName;
    private String treatmentNumber;
    private String treatmentType;
    private String treatmentDate;
    private String treatmentDescription;


    public TreatmentResponseDTO(){}

    public TreatmentResponseDTO(String doctorName,String patientName,String medicineName,
                                String treatmentName, String treatmentNumber,
                                String treatmentType,
                                String treatmentDate, String treatmentDescription) {
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.medicineName = medicineName;
        this.treatmentName = treatmentName;
        this.treatmentNumber = treatmentNumber;
        this.treatmentType = treatmentType;
        this.treatmentDate = treatmentDate;
        this.treatmentDescription = treatmentDescription;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public String getTreatmentNumber() {
        return treatmentNumber;
    }

    public void setTreatmentNumber(String treatmentNumber) {
        this.treatmentNumber = treatmentNumber;
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    public String getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(String treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public String getTreatmentDescription() {
        return treatmentDescription;
    }

    public void setTreatmentDescription(String treatmentDescription) {
        this.treatmentDescription = treatmentDescription;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }


    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }
}
