package com.example.instaclone.service;

import com.example.instaclone.dto.UserDto;
import com.example.instaclone.entity.User;
import com.example.instaclone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // ✅ SIGNUP
    public User registerUser(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return userRepository.save(user);
    }

    // ✅ LOGIN (ADD THIS)
    public User login(String email, String password) {

        System.out.println("👉 EMAIL FROM REQUEST = [" + email + "]");
        System.out.println("👉 PASSWORD FROM REQUEST = [" + password + "]");

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        System.out.println("👉 ENCODED PASSWORD IN DB = " + user.getPassword());

        boolean match = passwordEncoder.matches(password, user.getPassword());
        System.out.println("👉 PASSWORD MATCH RESULT = " + match);

        if (!match) {
            throw new RuntimeException("Invalid credentials");
        }

        return user;
    }

}
