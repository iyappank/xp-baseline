package com.example.products.service;

import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getProducts(Double minPrice) {
        if (minPrice == null) {
            return repo.findAll();
        }
        if (minPrice < 0) {
            throw new IllegalArgumentException("minPrice must be non-negative");
        }
        return repo.findByMinPrice(minPrice);
    }
}
