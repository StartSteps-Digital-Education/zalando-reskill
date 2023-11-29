package com.ecommerce.service;

import com.ecommerce.model.Product;

import java.util.List;

// Implement against interfaces
public interface ProductService {
    void addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(String id);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByPriceRange(double minPrice, double maxPrice);
}
