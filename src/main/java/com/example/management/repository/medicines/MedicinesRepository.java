package com.example.management.repository.medicines;

import com.example.management.entity.medicines.Medicines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicinesRepository extends JpaRepository<Medicines,Long> {

    Medicines findByMedicineName(String medicinesName);

}
