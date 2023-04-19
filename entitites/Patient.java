package com.example.hospital.entitites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Patients")
@Getter
@Setter
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private Long  doctorId;
    private Long blockId;
    private String address;
    private String insuranceNum;

    public Patient(String fullname, Long doctorId, Long blockId, String address, String insuranceNum) {
        this.fullname = fullname;
        this.doctorId = doctorId;
        this.blockId = blockId;
        this.address = address;
        this.insuranceNum = insuranceNum;
    }
}
