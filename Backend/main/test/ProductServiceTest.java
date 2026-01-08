package com.products;

import com.products.model.Product;
import com.products.repository.ProductRepository;
import com.products.service.ProductService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    @Test
    void returnsAllWhenMinPriceNull() {
        ProductService service = new ProductService(new ProductRepository());
        List<Product> products = service.getProducts(null);
        assertTrue(products.size() >= 4);
    }

    @Test
    void filtersByMinPrice() {
        ProductService service = new ProductService(new ProductRepository());
        List<Product> products = service.getProducts(3000.0);
        assertTrue(products.stream().allMatch(p -> p.getPrice() >= 3000.0));
    }

    @Test
    void negativeMinPriceThrows() {
        ProductService service = new ProductService(new ProductRepository());
        assertThrows(IllegalArgumentException.class, () -> service.getProducts(-1.0));
    }
}
