package com.example.instaclone.service;

import com.example.instaclone.entity.Post;
import com.example.instaclone.repository.FollowRepository;
import com.example.instaclone.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {

    private final FollowRepository followRepository;
    private final PostRepository postRepository;

    public List<Post> getFeed(Long userId) {

        List<Long> followingIds =
                followRepository.findFollowingIdsByFollowerId(userId);

        return postRepository.findByUserIdInOrderByCreatedAtDesc(followingIds);
    }
}
