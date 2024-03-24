package com.example.management.entity.treatment;

import com.example.management.entity.medicines.Medicines;

import com.example.management.entity.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "treatment")
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String treatmentName;

    private String treatmentNumber;
    private String treatmentType;
    private String treatmentDate;
    private String treatmentDescription;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private User doctor;

    @ManyToOne
    @JoinColumn(name = "nurse_id")
    private User nurse;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private User patient;

    @ManyToOne()
    @JoinColumn(name = "mediciens_id")
    private Medicines medicines;


    public Treatment(String treatmentName, String treatmentNumber, String treatmentType, String treatmentDate,
                     String treatmentDescription,
                     Medicines medicines,User doctor,User nurse,User patient) {

        this.treatmentName = treatmentName;
        this.treatmentNumber = treatmentNumber;
        this.treatmentType = treatmentType;
        this.treatmentDate = treatmentDate;
        this.treatmentDescription = treatmentDescription;
        this.medicines = medicines;
        this.doctor = doctor;
        this.nurse = nurse;
        this.patient = patient;
    }

    public Treatment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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



    public Medicines getMedicines() {
        return medicines;
    }

    public void setMedicines(Medicines medicines) {
        this.medicines = medicines;
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
