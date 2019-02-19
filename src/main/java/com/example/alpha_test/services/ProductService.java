package com.example.alpha_test.services;

import com.example.alpha_test.entities.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<List<Product>> findAll();
}
