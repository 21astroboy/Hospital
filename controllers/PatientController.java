package com.example.hospital.controllers;

import com.example.hospital.entitites.Patient;
import com.example.hospital.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("patient")
public class PatientController {
    @Autowired
    private static final PatientService patientServ = new PatientService();

    @GetMapping("")
    public Iterable<Patient> getAll() {
        return patientServ.findAllPatients();
    }

    @GetMapping("/{id}")
    public Optional<Patient> getDoc(@PathVariable long id) {
        return patientServ.findPatient(id);
    }

    @PostMapping("/add")
    public void addDoc(Patient patient) {
        patientServ.savePatient(patient);
    }

    @PutMapping("/{id}/edit")
    public void update(@PathVariable long id, String fullname, Long doctorId, Long blockId, String address, String insuranceNum) {
        patientServ.updatePatient(id, fullname, doctorId, blockId, address, insuranceNum);
    }

    @DeleteMapping("/{id}/remove")
    public void delete(@PathVariable long id) {
        patientServ.deletePatient(id);
    }
}
