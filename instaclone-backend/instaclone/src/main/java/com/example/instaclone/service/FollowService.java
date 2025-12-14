package com.example.instaclone.service;

import com.example.instaclone.entity.Follow;
import com.example.instaclone.entity.User;
import com.example.instaclone.repository.FollowRepository;
import com.example.instaclone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    public void follow(Long followerId, Long followingId) {

        if (followerId.equals(followingId)) {
            throw new RuntimeException("You cannot follow yourself");
        }

        if (followRepository.existsByFollower_IdAndFollowing_Id(followerId, followingId)) {
            throw new RuntimeException("Already following");
        }

        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Follower not found"));

        User following = userRepository.findById(followingId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowing(following);

        followRepository.save(follow);
    }

    public void unfollow(Long followerId, Long followingId) {
        followRepository.deleteByFollower_IdAndFollowing_Id(followerId, followingId);
    }

    public long followersCount(Long userId) {
        return followRepository.countByFollowing_Id(userId);
    }

    public long followingCount(Long userId) {
        return followRepository.countByFollower_Id(userId);
    }
}

