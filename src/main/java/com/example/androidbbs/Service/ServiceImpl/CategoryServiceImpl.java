package com.example.androidbbs.Service.ServiceImpl;

import com.example.androidbbs.Entity.Board;
import com.example.androidbbs.Entity.BoardCategory;
import com.example.androidbbs.Entity.Category;
import com.example.androidbbs.Repository.BoardCategoryRepository;
import com.example.androidbbs.Repository.BoardRepository;
import com.example.androidbbs.Repository.CategoryRepository;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ResponseBody<List<Category>> findAllCategory() {
        return ResponseBody.success(categoryRepository.findAll());
    }

    @Override
    public ResponseBody<String> createCategory(Category category) {
        categoryRepository.save(category);
        return null;
    }
}
