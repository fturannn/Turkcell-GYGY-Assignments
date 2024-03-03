package com.turkcell.pairproject1.services.concretes;

import com.turkcell.pairproject1.entities.Category;
import com.turkcell.pairproject1.repositories.abstracts.CategoryRepository;
import com.turkcell.pairproject1.requests.CategorySaveRequest;
import com.turkcell.pairproject1.requests.CategoryUpdateRequest;
import com.turkcell.pairproject1.services.abstracts.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(int id) {
        Category category = categoryRepository.findById(id);

        if(category == null) {
            throw new RuntimeException("İlgili Id'ye sahip kategori bulunamadı!");
        }

        return category;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(CategorySaveRequest request) {
        return categoryRepository.save(request);
    }

    @Override
    public Category update(int id, CategoryUpdateRequest request) {
        return categoryRepository.update(id, request);
    }

    @Override
    public void delete(int id) {
        Category category = categoryRepository.findById(id);

        if(category == null) {
            throw new RuntimeException("İlgili Id'ye sahip kategori bulunamadı!");
        }

        categoryRepository.delete(id);
    }
}
