package com.example.androidbbs.Service.ServiceImpl;

import com.example.androidbbs.Entity.Reply;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.ReplyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Override
    public ResponseBody<List<Reply>> findReplyByTopic() {
        return null;
    }
}
