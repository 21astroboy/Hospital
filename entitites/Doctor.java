package com.example.hospital.entitites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "doctors")
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
    private BigDecimal wage;
    private String workNumber;
    @OneToOne
    @JoinColumn(name = "directorId")
    private Block directorBlock;
    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

    public Doctor(String fullname, String position, Integer experience, Boolean isDirector, BigDecimal wage, String workNumber) {
        this.fullname = fullname;
        this.position = position;
        this.experience = experience;
        this.isDirector = isDirector;
        this.wage = wage;
        this.workNumber = workNumber;
    }
}
