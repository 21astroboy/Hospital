package com.example.hospital.dao;

import com.example.hospital.entitites.Patient;
import com.example.hospital.repo.PatientRepo;

import java.util.Optional;

public class PatientDAO {
    public static PatientRepo patientRepo;

    public Optional<Patient> getPatient(long id) {
        Optional<Patient> patient = patientRepo.findById(id);
        return patient;
    }

    public Iterable<Patient> getAllPatient() {
        Iterable<Patient> patients = patientRepo.findAll();
        return patients;
    }

    public void savePatient(Patient patient) {
        patientRepo.save(patient);
    }

    public void savePatient(String fullname, Long  doctorId, Long blockId, String address,String insuranceNum) {
        Patient patient = new Patient(fullname, doctorId, blockId,address, insuranceNum);
        patientRepo.save(patient);
    }

    public void deletePatient(long id) {
        patientRepo.deleteById(id);
    }

    public void deletePatient(Patient patient) {
        patientRepo.delete(patient);
    }

    public void updatePatient(long id, String fullname, Long doctorId, Long blockId, String address,String insuranceNum) {
        Patient patient = patientRepo.findById(id).orElseThrow();
        if (patientRepo.existsById(id)) {
            patient.setFullname(fullname);
            patient.setAddress(address);
            patient.setDoctorId(doctorId);
            patient.setBlockId(blockId);
            patient.setInsuranceNum(insuranceNum);
        }
    }
}
