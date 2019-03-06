package com.example.alpha_test.service;

import com.example.alpha_test.entity.BrandName;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface BrandNameService {
    ResponseEntity<List<BrandName>> findAll();
}
