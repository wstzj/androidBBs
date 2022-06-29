package com.example.androidbbs.Service;

import com.example.androidbbs.Entity.Reply;
import com.example.androidbbs.Response.ResponseBody;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReplyService {
    ResponseBody<List<Reply>> findReplyByTopicId(Long topicId);
}
