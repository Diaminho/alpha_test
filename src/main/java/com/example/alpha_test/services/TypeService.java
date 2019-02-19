package com.example.alpha_test.services;

import com.example.alpha_test.entities.Type;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TypeService {
    ResponseEntity<List<Type>> findAll();
}
