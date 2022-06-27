package com.example.androidbbs.Service;

import com.example.androidbbs.Entity.Board;
import com.example.androidbbs.Response.ResponseBody;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    ResponseBody<List<Board>> findAllBoard();
}
