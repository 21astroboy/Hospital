package com.example.hospital.services;
import com.example.hospital.entitites.Patient;
import com.example.hospital.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private  PatientRepo repo;


    public Patient findPatient(Long id) {
        return repo.getById(id);
    }

    public List<Patient> findAllPatients() {
        return repo.findAll();
    }

    public void savePatient(Patient patient) {
        repo.save(patient);
    }

    public void savePatient(String fullname, Long doctorId, Long blockId, String address, String insuranceNum,String phone) {
        Patient patient = new Patient(fullname,doctorId,blockId, address, insuranceNum,phone);
        repo.save(patient);
    }

    public void deletePatient(long id) {

        repo.deleteById(id);
    }

    public void deletePatients(Patient patient) {
        repo.delete(patient);
    }

    public void updatePatient(long id, String fullname, Long doctorId, Long blockId, String address, String insuranceNum,String phone) {
        Patient patient =  repo.getById(id);
        patient.setFullname(fullname);
        patient.setAddress(address);
        patient.setInsuranceNum(insuranceNum);
        patient.setBlockId(id);
        patient.setDoctorId(doctorId);
        patient.setPhone(phone);
        repo.save(patient);
    }
}
