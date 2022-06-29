package com.example.androidbbs.Repository;

import com.example.androidbbs.Entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Long> {
    Topic findTopicById(Long id);
}
