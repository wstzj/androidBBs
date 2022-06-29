package com.example.androidbbs.Service;

import com.example.androidbbs.Entity.Reply;
import com.example.androidbbs.Response.ResponseBody;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReplyService {
    ResponseBody<List<Reply>> findRepliesByTopicId(Long topicId);
    ResponseBody<List<Reply>> findRepliesByUserId(Long userId);
    ResponseBody<String> createReply(Reply reply,Long userId,Long topicId);
    ResponseBody<String> updateReply(Reply reply,Long replyId);
    ResponseBody<String> deleteReply(Long replyId);
}
