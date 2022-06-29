package com.example.androidbbs.Service.ServiceImpl;


import com.example.androidbbs.Entity.Board;
import com.example.androidbbs.Entity.BoardCategory;
import com.example.androidbbs.Repository.BoardCategoryRepository;
import com.example.androidbbs.Repository.BoardRepository;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardCategoryRepository boardCategoryRepository;

    @Override
    public ResponseBody<List<Board>> findBoardsByCategoryId(Long categoryId) {
        List<BoardCategory> boardCategoryList = boardCategoryRepository.findBoardCategoriesByCategoryId(categoryId);
        List<Board> boardList = new ArrayList<>();
        for (BoardCategory item : boardCategoryList) {
            Board board = boardRepository.findBoardById(item.getBoardId());
            boardList.add(board);
        }
        return ResponseBody.success(boardList);
    }
}
