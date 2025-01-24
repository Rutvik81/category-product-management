package com.example.category_product_management.exception;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

 class ProductNotFoundException extends ResourceNotFoundException {
    public ProductNotFoundException(String productId) {
        super("Product not found with id: " + productId);
    }
    
}
