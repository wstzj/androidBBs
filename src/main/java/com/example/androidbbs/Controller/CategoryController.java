package com.example.androidbbs.Controller;

import com.example.androidbbs.Entity.Category;
import com.example.androidbbs.Entity.User;
import com.example.androidbbs.Response.ResponseBody;
import com.example.androidbbs.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public ResponseBody<List<Category>> getCategory(){
        return categoryService.findAllCategory();
    }

    @PostMapping("/category")
    public ResponseBody<String> createCategory(@RequestBody Map<String, String> requestBody, Category category){
        return categoryService.createCategory(category);
    }
}
