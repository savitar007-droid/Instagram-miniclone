package com.example.instaclone.controller;

import com.example.instaclone.entity.Post;
import com.example.instaclone.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feed")
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Post>> feed(@PathVariable Long userId) {
        return ResponseEntity.ok(feedService.getFeed(userId));
    }
}
