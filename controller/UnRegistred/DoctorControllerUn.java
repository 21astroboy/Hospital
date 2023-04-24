package com.example.hospital.controller.UnRegistred;

import com.example.hospital.converter.Converter;
import com.example.hospital.dto.DoctorDTO;
import com.example.hospital.entitites.Doctor;
import com.example.hospital.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DoctorControllerUn {
    @Autowired
    DoctorService service;
    Converter converter = new Converter();

    @GetMapping("/all")
    public Iterable<DoctorDTO> getAllDoc() {
        Iterable<Doctor> doctors = service.findAllDoc();
        List<DoctorDTO> doctorDTOS = new ArrayList<>();

        for (var el : doctors)
            doctorDTOS.add(converter.DoctorDTOConv(el));
        return doctorDTOS;
    }

    @GetMapping("/{id}")
    public DoctorDTO getDoc(@PathVariable Long id) {
        return converter.DoctorDTOConv(service.findDoc(id));
    }
}

