package com.example.hospital.controller.Admin;

import com.example.hospital.entitites.Patient;
import com.example.hospital.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class PatientController {
    @Autowired
    PatientService service;


    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return service.findAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable Long id) {
        return service.findPatient(id);
    }

    @PostMapping("/add")
    public void savePatient(Patient patient) {
        service.savePatient(patient);
    }

    @PutMapping("/{id}/edit")
    public void update(
            @PathVariable Long id,
            String fullname,
            Long doctorId,
            Long blockId,
            String address,
            @Valid String insuranceNum,
            @Valid String phone
    ) {
        service.updatePatient(id, fullname, doctorId, blockId, address, insuranceNum, phone);
    }

    @DeleteMapping("/{id}/remove")

    public void delete(@PathVariable Long id) {
        service.deletePatients(service.findPatient(id));
    }
}
