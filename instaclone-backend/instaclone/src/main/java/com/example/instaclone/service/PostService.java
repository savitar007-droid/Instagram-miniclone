package com.example.instaclone.service;

import com.example.instaclone.entity.Post;
import com.example.instaclone.entity.User;
import com.example.instaclone.repository.PostRepository;
import com.example.instaclone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post createPost(Long userId, String imageUrl, String caption) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = new Post();
        post.setImageUrl(imageUrl);
        post.setCaption(caption);
        post.setUser(user);

        return postRepository.save(post);
    }
}
