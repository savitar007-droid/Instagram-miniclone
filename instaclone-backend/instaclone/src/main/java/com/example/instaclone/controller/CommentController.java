package com.example.instaclone.controller;

import com.example.instaclone.entity.Comment;
import com.example.instaclone.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{userId}/{postId}")
    public ResponseEntity<Comment> addComment(
            @PathVariable Long userId,
            @PathVariable Long postId,
            @RequestParam String text) {

        return ResponseEntity.ok(
                commentService.addComment(userId, postId, text)
        );
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable Long postId) {
        return ResponseEntity.ok(commentService.getComments(postId));
    }
}
