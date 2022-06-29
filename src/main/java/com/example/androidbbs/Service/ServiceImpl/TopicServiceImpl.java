package com.example.androidbbs.Service.ServiceImpl;

import com.example.androidbbs.Entity.Topic;
import com.example.androidbbs.Entity.TopicBoard;
import com.example.androidbbs.Repository.TopicBoardRepository;
import com.example.androidbbs.Repository.TopicRepository;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    TopicBoardRepository topicBoardRepository;

    @Override
    public ResponseBody<List<Topic>> findTopicsByBoardId(Long boardId) {
        List<TopicBoard> topicBoardList = topicBoardRepository.findTopicBoardsByBoardId(boardId);
        List<Topic> topicList = new ArrayList<>();
        for (TopicBoard item : topicBoardList) {
            Topic topic = topicRepository.findTopicById(item.getTopicId());
            topicList.add(topic);
        }
        return ResponseBody.success(topicList);
    }

    @Override
    public ResponseBody<Topic> findTopicById(Long topicId) {
        Topic topic = topicRepository.findTopicById(topicId);
        return ResponseBody.success(topic);
    }

    @Override
    public ResponseBody<String> createTopic(Topic topic, Long boardId) {
        Topic saveTopic = topicRepository.save(topic);
        TopicBoard topicBoard = new TopicBoard(saveTopic.getId(),boardId);
        topicBoardRepository.save(topicBoard);
        return ResponseBody.success("成功发布主题");
    }

    @Override
    public ResponseBody<String> deleteTopicById(Long topicId) {
        Topic topic = topicRepository.findTopicById(topicId);
        topicRepository.delete(topic);
        return ResponseBody.success("成功删除");
    }
}
