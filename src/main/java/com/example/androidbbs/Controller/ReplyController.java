package com.example.androidbbs.Controller;

import com.example.androidbbs.Entity.Reply;
import com.example.androidbbs.Entity.Topic;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReplyController {
    @Autowired
    ReplyService replyService;

    @PostMapping("/reply")
    public ResponseBody<String> saveReply(){
        return null;
    }

    @GetMapping("/topic/{topicId}/reply")
    public ResponseBody<List<Reply>> findRepliesByTopicId(@PathVariable("topicId") Long topicId){
        return replyService.findRepliesByTopicId(topicId);
    }
    @GetMapping("/user/{userId}/reply")
    public ResponseBody<List<Reply>> findRepliesByUserId(@PathVariable("userId") Long userId){
        return replyService.findRepliesByUserId(userId);
    }
}
