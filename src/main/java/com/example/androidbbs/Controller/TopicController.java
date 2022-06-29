package com.example.androidbbs.Controller;

import com.example.androidbbs.Entity.Topic;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TopicController {

    @Autowired
    TopicService topicService;

    @PostMapping("/topic")
    public ResponseBody<String> saveTopic(){
        return null;
    }

    @GetMapping("topic/{topicId}")
    public ResponseBody<Topic> showTopic(@PathVariable("topicId") Long topicId){
        return topicService.findTopicById(topicId);
    }

    @DeleteMapping("/topic/{topicId}")
    public  ResponseBody<String> deleteTopic(@PathVariable("topicId") Long topicId){
        return topicService.deleteTopicById(topicId);
    }

    @GetMapping("/board/{boardId}/topic")
    public ResponseBody<List<Topic>> findTopicsByBoardId(@PathVariable("boardId") Long boardId){
        return topicService.findTopicsByBoardId(boardId);
    }
    @GetMapping("/user/{userId}/topic")
    public ResponseBody<List<Topic>> findTopicsByUserId(@PathVariable("userId") Long userId){
        return topicService.findTopicsByUserId(userId);
    }
}
