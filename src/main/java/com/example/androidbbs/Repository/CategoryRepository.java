package com.example.androidbbs.Repository;

import com.example.androidbbs.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findCategoryById(Long id);
}
