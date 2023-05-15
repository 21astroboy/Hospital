package com.example.hospital.services;

import com.example.hospital.entitites.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User getUserById();
    User getCurrentUser();
    User getUserByPhone(String phone);
    User createUser(User user);
}
