package com.example.androidbbs.Service;

import com.example.androidbbs.Entity.Board;
import com.example.androidbbs.Entity.Category;
import com.example.androidbbs.Response.ResponseBody;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    ResponseBody<List<Category>> findAllCategory();
    ResponseBody<String> createCategory(Category category);
}
