package com.example.instaclone.controller;

import com.example.instaclone.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;

    @PostMapping("/{followerId}/{followingId}")
    public ResponseEntity<?> follow(
            @PathVariable Long followerId,
            @PathVariable Long followingId) {

        followService.follow(followerId, followingId);
        return ResponseEntity.ok("Followed successfully");
    }

    @DeleteMapping("/{followerId}/{followingId}")
    public ResponseEntity<?> unfollow(
            @PathVariable Long followerId,
            @PathVariable Long followingId) {

        followService.unfollow(followerId, followingId);
        return ResponseEntity.ok("Unfollowed successfully");
    }

    @GetMapping("/followers/{userId}")
    public ResponseEntity<?> followersCount(@PathVariable Long userId) {
        return ResponseEntity.ok(followService.followersCount(userId));
    }

    @GetMapping("/following/{userId}")
    public ResponseEntity<?> followingCount(@PathVariable Long userId) {
        return ResponseEntity.ok(followService.followingCount(userId));
    }
}
