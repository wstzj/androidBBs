package com.example.androidbbs.Service.ServiceImpl;

import com.example.androidbbs.Entity.BoardCategory;
import com.example.androidbbs.Entity.Category;
import com.example.androidbbs.Repository.BoardCategoryRepository;
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
    @Autowired
    BoardCategoryRepository boardCategoryRepository;

    @Override
    public ResponseBody<List<Category>> findCategoryByBoardId(Long id) {
        List<BoardCategory> boardCategoryList = boardCategoryRepository.findBoardCategoriesByBoardId(id);
        List<Category> categoryList = new ArrayList<>();
        for (BoardCategory item : boardCategoryList) {
            Category category = categoryRepository.findCategoryById(item.getCategoryId());
            categoryList.add(category);
        }
        return ResponseBody.success(categoryList);
    }
}
