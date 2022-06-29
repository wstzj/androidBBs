package com.example.androidbbs.Service;

import com.example.androidbbs.Entity.Topic;
import com.example.androidbbs.Response.ResponseBody;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TopicService {
    ResponseBody<List<Topic>> findTopicsByBoardId(Long boardId);
    ResponseBody<List<Topic>> findTopicsByUserId(Long userId);
    ResponseBody<Topic> findTopicById(Long topicId);
    ResponseBody<String> createTopic(Topic topic,Long boardId);
    ResponseBody<String> deleteTopicById(Long topicId);
}
