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


    public void forgotPassword(String email) {

    email = email.trim().toLowerCase(Locale.ROOT);

    UserCredential user = userRepository.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("Account not found"));

    resetTokenRepository.deleteByEmail(email);

    byte[] randomBytes = new byte[32];
    new SecureRandom().nextBytes(randomBytes);

    String token = Base64.getUrlEncoder()
            .withoutPadding()
            .encodeToString(randomBytes);

    PasswordResetToken resetToken = new PasswordResetToken();
    resetToken.setEmail(user.getEmail());
    resetToken.setToken(token);
    resetToken.setExpiryDate(LocalDateTime.now().plusMinutes(15));
    resetToken.setUsed(false);

    resetTokenRepository.save(resetToken);

    // Temporary development output.
    // We'll replace this with email delivery later.
    System.out.println("Password reset token: " + token);
}


public void resetPassword(String token, String newPassword) {

    PasswordResetToken resetToken = resetTokenRepository.findByToken(token)
            .orElseThrow(() -> new IllegalArgumentException("Invalid reset token"));

    if (resetToken.isUsed()
            || resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {

        throw new IllegalArgumentException("Reset token is expired or already used");
    }

    UserCredential user = userRepository.findByEmail(resetToken.getEmail())
            .orElseThrow(() -> new IllegalArgumentException("Account not found"));

    user.setPassword(passwordEncoder.encode(newPassword));
    userRepository.save(user);

    resetToken.setUsed(true);
    resetTokenRepository.save(resetToken);
}
}
