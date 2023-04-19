package com.example.hospital.repo;

import com.example.hospital.entitites.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorsRepo extends JpaRepository<Doctor,Long> {
    /*public Doctor getDoctor(long id);
    public List<Doctor> getAllDoctors();
    public void saveDoctor(Doctor doctor);
    public void deleteDoctor(long id);*/
}
