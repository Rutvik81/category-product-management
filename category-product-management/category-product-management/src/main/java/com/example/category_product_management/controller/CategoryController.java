package com.example.category_product_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.category_product_management.entity.Category;
import com.example.category_product_management.exception.ResourceNotFoundException;
import com.example.category_product_management.repository.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        // Logic for paginated list of categories
        return categoryRepository.findAll();
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        category.setName(categoryDetails.getName());
        return categoryRepository.save(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }
}
