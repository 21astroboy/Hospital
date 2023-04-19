package com.example.hospital.entitites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "blocks")
@Getter
@Setter
@NoArgsConstructor
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String address;
    private String phone;
    private Long directorId;

    public Block(String title, String address, String phone, Long directorId) {
        this.title = title;
        this.address = address;
        this.phone = phone;
        this.directorId = directorId;
    }
}