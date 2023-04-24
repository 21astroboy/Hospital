package com.example.hospital.controller.UnRegistred;

import com.example.hospital.converter.Converter;
import com.example.hospital.dto.PatientDTO;
import com.example.hospital.entitites.Patient;
import com.example.hospital.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PatientControllerUn {
    @Autowired
    PatientService service;
    Converter converter = new Converter();

    @GetMapping("/all")
    public Iterable<PatientDTO> getAllPa() {
        Iterable<Patient> patients = service.findAllPatients();
        List<PatientDTO> patientDTOS = new ArrayList<>();

        for (var el : patients)
            patientDTOS.add(converter.PatientDTOConv(el));
        return patientDTOS;
    }

    @GetMapping("/{id}")
    public PatientDTO getDoc(@PathVariable Long id) {
        return converter.PatientDTOConv(service.findPatient(id));
    }
}


