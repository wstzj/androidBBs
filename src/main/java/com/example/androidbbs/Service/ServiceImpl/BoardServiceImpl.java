package com.example.androidbbs.Service.ServiceImpl;


import com.example.androidbbs.Entity.Board;
import com.example.androidbbs.Repository.BoardRepository;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public ResponseBody<List<Board>> findAllBoard() {
        List<Board> boardList = boardRepository.findAll();
        return ResponseBody.success(boardList);
    }
}
