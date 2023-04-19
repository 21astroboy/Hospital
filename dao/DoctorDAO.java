package com.example.hospital.dao;

import com.example.hospital.entitites.Doctor;
import com.example.hospital.repo.DoctorsRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DoctorDAO {

    public static DoctorsRepo doctorsRepo;
    public Optional<Doctor> getDoctor(long id){
        Optional<Doctor> doctor = doctorsRepo.findById(id);
        return doctor;
    }
    public Iterable<Doctor> getAllDoctors(){
        Iterable<Doctor> doctors = doctorsRepo.findAll();
        return doctors;
    }
    public void saveDoctor(Doctor doctor){
        doctorsRepo.save(doctor);
    }
    public void saveDoctor(String fullname, String position, int experience, boolean isDir ){
        Doctor doctor =new Doctor(fullname,position,experience,isDir);
        doctorsRepo.save(doctor);
    }
    public void deleteDoctor(long id){
        doctorsRepo.deleteById(id);
    }
    public void deleteDoctor(Doctor doctor){
        doctorsRepo.delete(doctor);
    }
    public void updateDoc(long id, String fullname, String position, int exp, boolean isDir){
        Doctor doctor = doctorsRepo.findById(id).orElseThrow();
        if(doctorsRepo.existsById(id)){
            doctor.setFullname(fullname);
            doctor.setPosition(position);
            doctor.setExperience(exp);
            doctor.setIsDirector(isDir);
        }
    }
}
