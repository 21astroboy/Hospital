package com.example.hospital.entitites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Doctors")
@Getter
@Setter
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String position;
    private Integer experience;
    private Boolean isDirector;

    public Doctor(String fullname, String position, Integer experience, Boolean isDirector) {
        this.fullname = fullname;
        this.position = position;
        this.experience = experience;
        this.isDirector = isDirector;
    }
}