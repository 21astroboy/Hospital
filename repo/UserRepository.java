package com.example.hospital.repo;

import com.example.hospital.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Long> {
    User findByPhone(String phone);
    User findByEmail(String email);

}
