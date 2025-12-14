package com.example.instaclone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "followers")
@IdClass(FollowId.class)
public class Follow {

    @Id
    @ManyToOne
    @JoinColumn(name = "follower_id")
    private User follower;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User following;

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowing() {
        return following;
    }

    public void setFollowing(User following) {
        this.following = following;
    }
}
