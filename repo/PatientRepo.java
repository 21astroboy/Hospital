package com.example.hospital.repo;

import com.example.hospital.entitites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient,Long> {
}
