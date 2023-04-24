package com.example.hospital.repo;

import com.example.hospital.entitites.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsRepo extends JpaRepository<Doctor, Long> {

}
