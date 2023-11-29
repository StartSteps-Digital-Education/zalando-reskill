package com.ecommerce.service;

import com.ecommerce.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    private static final List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(String id) {
        Optional<Product> product = products
                .stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst();

        return product.orElse(null);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return products
                .stream()
                .filter(p -> Objects.equals(p.getCategory(), category))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        return products
                .stream()
                .filter(p -> p.getPrice() > minPrice && p.getPrice() < maxPrice)
                .collect(Collectors.toList());
    }
}
