package com.example.category_product_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.category_product_management.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
