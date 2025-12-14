package com.example.instaclone.controller;

import com.example.instaclone.dto.LoginRequest;
import com.example.instaclone.dto.UserDto;
import com.example.instaclone.entity.User;
import com.example.instaclone.security.JwtUtil;
import com.example.instaclone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        try {
            User user = userService.registerUser(userDto);
            return ResponseEntity.ok("User registered: " + user.getUsername());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            User user = userService.login(request.getEmail(), request.getPassword());
            String token = jwtUtil.generateToken(user.getEmail());
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}
