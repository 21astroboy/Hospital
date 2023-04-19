package com.example.hospital.services;

import com.example.hospital.dao.DoctorDAO;
import com.example.hospital.entitites.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private static DoctorDAO doctorDAO = new DoctorDAO();
    public Optional<Doctor> findDoc(Long id){
        return doctorDAO.getDoctor(id);
    }
    public Iterable<Doctor> findAllDoc(){
        return doctorDAO.getAllDoctors();
    }
    public void saveDoc(Doctor doctor){
        doctorDAO.saveDoctor(doctor);
    }

    public void saveDoc(String fullname, String position, int experience, boolean isDir){
        doctorDAO.saveDoctor(fullname,position,experience,isDir);
    }
    public void deleteDoc(long id){

        doctorDAO.deleteDoctor(id);
    }
    public void deleteDoctors(Doctor doctor){
        doctorDAO.deleteDoctor(doctor);
    }
    public void updateDoc(long id, String fullname, String position, int exp, boolean isDir){
        doctorDAO.updateDoc(id,fullname,position,exp, isDir);
    }
}
