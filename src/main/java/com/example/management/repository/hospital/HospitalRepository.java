package com.example.management.repository.hospital;

import com.example.management.entity.hospital.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long> {

    Hospital findByHospitalName(String hospitalName);
}
