package com.example.androidbbs.Service.ServiceImpl;

import com.example.androidbbs.Entity.Reply;
import com.example.androidbbs.Entity.ReplyTopic;
import com.example.androidbbs.Repository.ReplyRepository;
import com.example.androidbbs.Repository.ReplyTopicRepository;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyRepository replyRepository;

    @Autowired
    ReplyTopicRepository replyTopicRepository;

    @Override
    public ResponseBody<List<Reply>> findReplyByTopicId(Long topicId) {
        List<ReplyTopic> replyTopicList = replyTopicRepository.findReplyTopicsByTopicId(topicId);
        List<Reply> replyList = new ArrayList<>();
        for (ReplyTopic item: replyTopicList) {
            Reply reply = replyRepository.findReplyById(item.getReplyId());
            replyList.add(reply);
        }
        return ResponseBody.success(replyList);
    }
}
