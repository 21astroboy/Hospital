package com.example.hospital.repo;

import com.example.hospital.entitites.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocksRepo extends JpaRepository<Block,Long> {
}
