package com.example.androidbbs.Repository;

import com.example.androidbbs.Entity.TopicBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicBoardRepository extends JpaRepository<TopicBoard,Long> {
    List<TopicBoard> findTopicBoardsByBoardId(Long boardId);
}
