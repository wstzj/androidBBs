package com.example.androidbbs.Repository;

import com.example.androidbbs.Entity.BoardCategory;
import com.example.androidbbs.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardCategoryRepository extends JpaRepository<BoardCategory,Long> {
    List<BoardCategory> findBoardCategoriesByCategoryId(Long id);
}
