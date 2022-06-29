package com.example.androidbbs.Repository;

import com.example.androidbbs.Entity.Reply;
import com.example.androidbbs.Entity.ReplyTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyTopicRepository extends JpaRepository<ReplyTopic,Long> {
    List<ReplyTopic> findReplyTopicsByTopicId(Long topicId);
    ReplyTopic findReplyTopicByReplyId(Long replyId);
}
