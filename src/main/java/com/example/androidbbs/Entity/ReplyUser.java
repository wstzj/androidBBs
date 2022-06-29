package com.example.androidbbs.Entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "reply_user")
public class ReplyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //主键

    private Long replyId; //回复主键

    private Long userId; //用户主键

    @CreatedDate
    private Date createTime; //创建时间

    public ReplyUser(Long replyId, Long userId) {
        this.replyId = replyId;
        this.userId = userId;
    }

    public ReplyUser() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
