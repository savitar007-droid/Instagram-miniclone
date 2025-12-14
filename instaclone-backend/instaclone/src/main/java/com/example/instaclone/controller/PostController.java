package com.example.instaclone.controller;

import com.example.instaclone.entity.Post;
import com.example.instaclone.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.instaclone.dto.PostDto;


@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/{userId}")
    public ResponseEntity<?> createPost(
            @PathVariable Long userId,
            @RequestBody PostDto postDto) {

        return ResponseEntity.ok(
                postService.createPost(
                        userId,
                        postDto.getImageUrl(),
                        postDto.getCaption()
                )
        );
    }
}
