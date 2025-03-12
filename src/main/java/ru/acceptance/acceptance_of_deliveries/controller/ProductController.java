package ru.acceptance.acceptance_of_deliveries.controller;

import lombok.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.acceptance.acceptance_of_deliveries.model.Product;
import ru.acceptance.acceptance_of_deliveries.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products") // More specific and informative request mapping
@Slf4j // Automatically creates a logger field called 'log'
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        log.info("Fetching all products...");
        return List.of(Product.builder().name("a").price(BigDecimal.valueOf(1)).build());
    }
}