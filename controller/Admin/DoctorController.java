package com.example.hospital.controller.Admin;

import com.example.hospital.entitites.Doctor;
import com.example.hospital.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/admin/doctors")
public class DoctorController {
    @Autowired
    DoctorService service;

    @GetMapping("/all")
    public Iterable<Doctor> getAllDoc() {
        return service.findAllDoc();
    }

    @GetMapping("/{id}")
    public Doctor getDoc(@PathVariable Long id) {
        return service.findDoc(id);
    }

    @PostMapping("/add")
    public void saveDoc(Doctor doctor) {
        service.saveDoc(doctor);
    }

    @PutMapping("/{id}/edit")
    public void update(
            @PathVariable Long id,
            String fullname,
            String position,
            Integer experience,
            Boolean isDirector,
            BigDecimal wage,
            @Valid String workNumber
    ) {
        service.updateDoc(id, fullname, position, experience, isDirector, wage, workNumber);
    }

    @DeleteMapping("/{id}/remove")

    public void delete(@PathVariable Long id) {
        service.deleteDoc(id);
    }
}
