package com.example.androidbbs.Repository;

import com.example.androidbbs.Entity.TopicUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicUserRepository extends JpaRepository<TopicUser,Long> {
    List<TopicUser> findTopicUsersByUserId(Long userId);
    TopicUser findTopicUserByTopicId(Long topicId);
}
