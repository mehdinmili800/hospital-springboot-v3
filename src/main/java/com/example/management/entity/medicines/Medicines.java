package com.example.management.entity.medicines;

import com.example.management.entity.treatment.Treatment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medicines")
public class Medicines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicineName;
    private String medicine_company;
    private String medicine_composition;
    private String medicine_cost;
    private String medicine_type;
    private String medicine_dose;
    private String medicine_description;

    @OneToMany(mappedBy = "medicines")
    @JsonIgnore
    private List<Treatment> treatments = new ArrayList<>();


    public Medicines(Long id, String medicineName, String medicine_company, String medicine_composition,
                     String medicine_cost, String medicine_type, String medicine_dose, String medicine_description) {
        this.id = id;
        this.medicineName = medicineName;
        this.medicine_company = medicine_company;
        this.medicine_composition = medicine_composition;
        this.medicine_cost = medicine_cost;
        this.medicine_type = medicine_type;
        this.medicine_dose = medicine_dose;
        this.medicine_description = medicine_description;
    }


    public Medicines() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicine_company() {
        return medicine_company;
    }

    public void setMedicine_company(String medicine_company) {
        this.medicine_company = medicine_company;
    }

    public String getMedicine_composition() {
        return medicine_composition;
    }

    public void setMedicine_composition(String medicine_composition) {
        this.medicine_composition = medicine_composition;
    }

    public String getMedicine_cost() {
        return medicine_cost;
    }

    public void setMedicine_cost(String medicine_cost) {
        this.medicine_cost = medicine_cost;
    }

    public String getMedicine_type() {
        return medicine_type;
    }

    public void setMedicine_type(String medicine_type) {
        this.medicine_type = medicine_type;
    }

    public String getMedicine_dose() {
        return medicine_dose;
    }

    public void setMedicine_dose(String medicine_dose) {
        this.medicine_dose = medicine_dose;
    }

    public String getMedicine_description() {
        return medicine_description;
    }

    public void setMedicine_description(String medicine_description) {
        this.medicine_description = medicine_description;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }
}
