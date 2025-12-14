package com.example.instaclone.controller;

import com.example.instaclone.entity.User;
import com.example.instaclone.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/{id}/follow")
    public void follow(@PathVariable Long id, HttpServletRequest request) {
        String email = (String) request.getAttribute("email");
        User me = userRepository.findByEmail(email).orElseThrow();
        User other = userRepository.findById(id).orElseThrow();

        other.getFollowers().add(me);
        userRepository.save(other);
    }
}
