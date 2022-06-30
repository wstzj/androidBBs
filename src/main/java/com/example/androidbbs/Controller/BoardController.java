package com.example.androidbbs.Controller;

import com.example.androidbbs.Entity.Board;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/category/{categoryId}/board")
    public ResponseBody<List<Board>> findTopicsByUserId(@PathVariable("categoryId") Long categoryId){
        return boardService.findBoardsByCategoryId(categoryId);
    }

}
