package com.example.alpha_test.services;

import com.example.alpha_test.entities.Property;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PropertyService {
    ResponseEntity<List<Property>> findAll();
}
