package com.example.alpha_test.service;

import com.example.alpha_test.entity.Property;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PropertyService {
    ResponseEntity<List<Property>> findAll();
}
