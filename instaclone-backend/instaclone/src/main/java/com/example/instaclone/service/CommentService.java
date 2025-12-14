package com.example.instaclone.service;

import com.example.instaclone.entity.Comment;
import com.example.instaclone.entity.Post;
import com.example.instaclone.entity.User;
import com.example.instaclone.repository.CommentRepository;
import com.example.instaclone.repository.PostRepository;
import com.example.instaclone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Comment addComment(Long userId, Long postId, String text) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setText(text);

        return commentRepository.save(comment);
    }

    public List<Comment> getComments(Long postId) {
        return commentRepository.findByPostId(postId);
    }
}
