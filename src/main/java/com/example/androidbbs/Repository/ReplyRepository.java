package com.example.androidbbs.Repository;

import com.example.androidbbs.Entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply,Long> {
    Reply findReplyById(Long id);
}
