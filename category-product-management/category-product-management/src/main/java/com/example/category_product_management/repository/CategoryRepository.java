package com.example.category_product_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.category_product_management.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
