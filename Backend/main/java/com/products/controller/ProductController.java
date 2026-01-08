package com.products.controller;

import com.products.model.Product;
import com.products.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @Operation(summary = "Get products", description = "Returns a list of products. Optional filter: minPrice")
    @GetMapping
    public List<Product> getProducts(
            @Parameter(description = "Filter products with price >= minPrice")
            @RequestParam(name = "minPrice", required = false) Double minPrice
    ) {
        return service.getProducts(minPrice);
    }
}
