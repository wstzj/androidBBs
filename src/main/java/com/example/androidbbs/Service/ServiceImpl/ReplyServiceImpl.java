package com.example.androidbbs.Service.ServiceImpl;

import com.example.androidbbs.Entity.Reply;
import com.example.androidbbs.Entity.ReplyTopic;
import com.example.androidbbs.Entity.ReplyUser;
import com.example.androidbbs.Repository.ReplyRepository;
import com.example.androidbbs.Repository.ReplyTopicRepository;
import com.example.androidbbs.Repository.ReplyUserRepository;
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

    @Autowired
    ReplyUserRepository replyUserRepository;

    @Override
    public ResponseBody<List<Reply>> findRepliesByTopicId(Long topicId) {
        List<ReplyTopic> replyTopicList = replyTopicRepository.findReplyTopicsByTopicId(topicId);
        List<Reply> replyList = new ArrayList<>();
        for (ReplyTopic item: replyTopicList) {
            Reply reply = replyRepository.findReplyById(item.getReplyId());
            replyList.add(reply);
        }
        return ResponseBody.success(replyList);
    }

    @Override
    public ResponseBody<List<Reply>> findRepliesByUserId(Long userId) {
        List<ReplyUser> replyUserList = replyUserRepository.findReplyUsersByUserId(userId);
        List<Reply> replyList = new ArrayList<>();
        for (ReplyUser item: replyUserList) {
            Reply reply = replyRepository.findReplyById(item.getReplyId());
            replyList.add(reply);
        }
        return ResponseBody.success(replyList);
    }

    @Override
    public ResponseBody<String> createReply(Reply reply, Long userId, Long topicId) {
        Reply saveReply = replyRepository.save(reply);
        ReplyTopic replyTopic = new ReplyTopic(saveReply.getId(), topicId);
        replyTopicRepository.save(replyTopic);
        ReplyUser replyUser = new ReplyUser(saveReply.getId(), userId);
        replyUserRepository.save(replyUser);
        return ResponseBody.success("成功回复");
    }

    @Override
    public ResponseBody<String> updateReply(Reply reply, Long replyId) {
        return null;
    }

    @Override
    public ResponseBody<String> deleteReply(Long replyId) {
        replyRepository.deleteReplyById(replyId);
        replyUserRepository.deleteReplyUserByReplyId(replyId);
        replyTopicRepository.deleteReplyTopicByReplyId(replyId);
        return ResponseBody.success("成功删除");
    }

}
