package com.example.hospital.controllers;

import com.example.hospital.entitites.Doctor;
import com.example.hospital.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    private static final DoctorService doctorService = new DoctorService();

    @GetMapping("")
    public Iterable<Doctor> getAll() {
        return doctorService.findAllDoc();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoc(@PathVariable long id) {
        return doctorService.findDoc(id);
    }

    @PostMapping("/add")
    public void addDoc(Doctor doc) {
        doctorService.saveDoc(doc);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, String fullname, String position, int exp, boolean isDir) {

        doctorService.updateDoc(id, fullname, position, exp, isDir);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        doctorService.deleteDoc(id);
    }
}
