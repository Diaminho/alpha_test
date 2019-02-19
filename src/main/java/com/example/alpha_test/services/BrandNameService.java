package com.example.alpha_test.services;

import com.example.alpha_test.entities.BrandName;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface BrandNameService {
    ResponseEntity<List<BrandName>> findAll();
}
