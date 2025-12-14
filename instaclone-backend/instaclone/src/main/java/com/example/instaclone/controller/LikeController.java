package com.example.instaclone.controller;

import com.example.instaclone.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/{userId}/{postId}")
    public ResponseEntity<?> like(
            @PathVariable Long userId,
            @PathVariable Long postId) {

        likeService.likePost(userId, postId);
        return ResponseEntity.ok("Post liked");
    }

    @DeleteMapping("/{userId}/{postId}")
    public ResponseEntity<?> unlike(
            @PathVariable Long userId,
            @PathVariable Long postId) {

        likeService.unlikePost(userId, postId);
        return ResponseEntity.ok("Post unliked");
    }

    @GetMapping("/count/{postId}")
    public ResponseEntity<Long> count(@PathVariable Long postId) {
        return ResponseEntity.ok(likeService.likeCount(postId));
    }
}
