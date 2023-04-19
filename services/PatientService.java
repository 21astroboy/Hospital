package com.example.hospital.services;

import com.example.hospital.dao.PatientDAO;
import com.example.hospital.entitites.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private static PatientDAO patientDAO = new PatientDAO();

    public Optional<Patient> findPatient(Long id) {
        return patientDAO.getPatient(id);
    }

    public Iterable<Patient> findAllPatients() {
        return patientDAO.getAllPatient();
    }

    public void savePatient(Patient patient) {
        patientDAO.savePatient(patient);
    }

    public void savePatient(String fullname, Long doctorId, Long blockId, String address, String insuranceNum) {
        patientDAO.savePatient(fullname, doctorId, blockId, address, insuranceNum);
    }

    public void deletePatient(long id) {

        patientDAO.deletePatient(id);
    }

    public void deletePatients(Patient patient) {
        patientDAO.deletePatient(patient);
    }

    public void updatePatient(long id, String fullname, Long doctorId, Long blockId, String address, String insuranceNum) {
        patientDAO.updatePatient(id, fullname, doctorId, blockId, address, insuranceNum);
    }
}
