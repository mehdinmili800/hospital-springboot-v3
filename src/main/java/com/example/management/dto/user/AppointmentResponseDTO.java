package com.example.management.dto.user;




public class AppointmentResponseDTO {


    private String doctorName;
    private String nurseName;
    private String patientName;
    private String hospitalName;
    private String appointmentNumber;
    private String appointmentType;
    private String appointmentDate;
    private String appointmentDescription;

    // Constructor, getters, and setters

    public AppointmentResponseDTO() {
    }

    public AppointmentResponseDTO(String doctorName,String nurseName,String patientName,String hospitalName,
                                  String appointmentNumber, String appointmentType,
                          String appointmentDate, String appointmentDescription) {
        this.doctorName = doctorName;
        this.nurseName = nurseName;
        this.patientName = patientName;
        this.appointmentNumber = appointmentNumber;
        this.appointmentType = appointmentType;
        this.appointmentDate = appointmentDate;
        this.appointmentDescription = appointmentDescription;

    }

    // Getters and setters...


    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
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


    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
