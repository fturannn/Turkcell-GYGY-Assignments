package com.turkcell.pairproject1.controllers;

import com.turkcell.pairproject1.entities.Category;
import com.turkcell.pairproject1.requests.CategorySaveRequest;
import com.turkcell.pairproject1.requests.CategoryUpdateRequest;
import com.turkcell.pairproject1.services.abstracts.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable int id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public Category save(@RequestBody CategorySaveRequest request) {
        return categoryService.save(request);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable int id, @RequestBody CategoryUpdateRequest request) {
        return categoryService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryService.delete(id);
    }
}
