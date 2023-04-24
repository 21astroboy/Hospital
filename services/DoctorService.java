package com.example.hospital.services;

import com.example.hospital.entitites.Doctor;
import com.example.hospital.repo.DoctorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DoctorService {
    @Autowired
    private DoctorsRepo repo;


    public Doctor findDoc(Long id) {
        return repo.getById(id);
    }

    public Iterable<Doctor> findAllDoc() {
        return repo.findAll();
    }

    public void saveDoc(Doctor doctor) {
        repo.save(doctor);
    }

    public void saveDoc(String fullname, String position, int experience, boolean isDir, BigDecimal wage, String workNumber) {
        Doctor doc = new Doctor(fullname, position, experience, isDir, wage, workNumber);
        repo.save(doc);
    }

    public void deleteDoc(long id) {

        repo.deleteById(id);
    }

    public void deleteDoctors(Doctor doctor) {
        repo.delete(doctor);
    }

    public void updateDoc(long id, String fullname, String position, int exp, boolean isDir, BigDecimal wage, String phone) {
        Doctor doctor = repo.findById(id).orElseThrow();
        doctor.setFullname(fullname);
        doctor.setPosition(position);
        doctor.setIsDirector(isDir);
        doctor.setExperience(exp);
        doctor.setWage(wage);
        doctor.setWorkNumber(phone);
        repo.save(doctor);
    }
}
