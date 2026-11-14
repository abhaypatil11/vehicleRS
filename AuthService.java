package com.rental.vehiclerental.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rental.vehiclerental.dto.RegisterRequest;
import com.rental.vehiclerental.entity.User;
import com.rental.vehiclerental.enums.Role;
import com.rental.vehiclerental.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public String register(RegisterRequest request) {

        // Check whether email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already registered");
        }

        // Create a new user
        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());

        // Encrypt password
        user.setPassword(
            passwordEncoder.encode(request.getPassword())
        );

        // Normal users cannot register as admins
        user.setRole(Role.ROLE_USER);

        user.setEnabled(true);

        // Save user in database
        userRepository.save(user);

        return "Registration successful";
    }
}
