package com.turkcell.pairproject1.repositories.concretes;

import com.turkcell.pairproject1.entities.Category;
import com.turkcell.pairproject1.repositories.abstracts.CategoryRepository;
import com.turkcell.pairproject1.requests.CategorySaveRequest;
import com.turkcell.pairproject1.requests.CategoryUpdateRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final List<Category> categoryList;

    public CategoryRepositoryImpl(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public Category findById(int id) {
        return categoryList.
                stream().filter(category -> category.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryList;
    }

    @Override
    public Category save(CategorySaveRequest request) {
        Category category = new Category();
        category.setId(request.id());
        category.setName(request.name());
        categoryList.add(category);
        return category;
    }

    @Override
    public Category update(int id, CategoryUpdateRequest request) {
        Category category = this.findById(id);
        category.setName(request.name());
        return category;
    }

    @Override
    public void delete(int id) {
        Category category = this.findById(id);
        categoryList.remove(category);
    }
}
