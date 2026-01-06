package com.example.products.repository;

import com.example.products.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private final Map<Long, Product> store = new ConcurrentHashMap<>();

    public ProductRepository() {
        // Seed data
        store.put(1L, new Product(1L, "Wireless Mouse", 999.0, "Ergonomic 2.4GHz mouse"));
        store.put(2L, new Product(2L, "Mechanical Keyboard", 3499.0, "Compact 65% with blue switches"));
        store.put(3L, new Product(3L, "USB-C Hub", 1999.0, "HDMI, USB 3.0, Power Delivery"));
        store.put(4L, new Product(4L, "Noise-cancelling Headphones", 5999.0, "Over-ear, 35h battery"));
    }

    public List<Product> findAll() {
        return store.values().stream()
                .sorted(Comparator.comparing(Product::getId))
                .collect(Collectors.toList());
    }

    public List<Product> findByMinPrice(Double minPrice) {
        return store.values().stream()
                .filter(p -> p.getPrice() >= minPrice)
                .sorted(Comparator.comparing(Product::getId))
                .collect(Collectors.toList());
    }
}
 