package com.example.hospital.entitites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private Long doctorId;
    private Long blockId;
    private String address;
    private String insuranceNum;
    private String phone;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Patient(String fullname, Long doctorId, Long blockId, String address, String insuranceNum,String phone) {
        this.fullname = fullname;
        this.doctorId = doctorId;
        this.blockId = blockId;
        this.address = address;
        this.insuranceNum = insuranceNum;
        this.phone = phone;
    }
}
