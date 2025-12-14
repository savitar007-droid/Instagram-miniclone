package com.example.instaclone.service;

import com.example.instaclone.entity.Post;
import com.example.instaclone.entity.PostLike;
import com.example.instaclone.entity.User;
import com.example.instaclone.repository.PostLikeRepository;
import com.example.instaclone.repository.PostRepository;
import com.example.instaclone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final PostLikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public void likePost(Long userId, Long postId) {

        if (likeRepository.existsByUserIdAndPostId(userId, postId)) {
            throw new RuntimeException("Already liked");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        PostLike like = new PostLike();
        like.setUser(user);
        like.setPost(post);

        likeRepository.save(like);
    }

    public void unlikePost(Long userId, Long postId) {
        likeRepository.deleteByUserIdAndPostId(userId, postId);
    }

    public long likeCount(Long postId) {
        return likeRepository.countByPostId(postId);
    }
}
