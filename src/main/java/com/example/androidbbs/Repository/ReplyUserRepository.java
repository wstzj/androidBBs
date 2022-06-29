package com.example.androidbbs.Repository;

import com.example.androidbbs.Entity.ReplyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyUserRepository extends JpaRepository<ReplyUser,Long> {
    List<ReplyUser> findReplyUsersByUserId(Long userId);
    ReplyUser findReplyUserByReplyId(Long replyId);
    void deleteReplyUserByReplyId(Long replyId);
}
