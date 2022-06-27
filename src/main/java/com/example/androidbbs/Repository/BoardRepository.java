package com.example.androidbbs.Repository;

import com.example.androidbbs.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    Board findBoardById(Long id);
}
