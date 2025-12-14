package com.example.instaclone.repository;

import com.example.instaclone.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.instaclone.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserIdInOrderByCreatedAtDesc(List<Long> userIds);
}
