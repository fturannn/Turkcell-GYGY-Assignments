package com.turkcell.pairproject1.services.abstracts;

import com.turkcell.pairproject1.entities.Category;
import com.turkcell.pairproject1.requests.CategorySaveRequest;
import com.turkcell.pairproject1.requests.CategoryUpdateRequest;

import java.util.List;

public interface CategoryService {
    Category findById(int id);
    List<Category> findAll();
    Category save(CategorySaveRequest request);
    Category update(int id, CategoryUpdateRequest request);
    void delete(int id);
}
